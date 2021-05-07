package kasyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//Контроллер для скачивания файла и подгрузки изображений

@RequestMapping("/download")
@Controller
public class DownloadsController {

    @RequestMapping("/xls/{fileName:.+}")
    public void downloadPDFResource(HttpServletRequest request,
                                    HttpServletResponse response,
                                    @PathVariable("fileName") String fileName) {
        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/xls/");
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file)) {
            response.setContentType("application/xls");
            response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
            try {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}