package br.com.t1tecnologia.finderj.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import br.com.t1tecnologia.finderj.enums.FileSaverPath;

public class FileSaver {
	public static String saveFile(MultipartFile logo, String fileName,
			FileSaverPath urlPath, HttpServletRequest request) throws Exception {
		String realPath = getRealPath(request, "/" + urlPath.getfileSaverPath());
		createFolder(realPath);
		String destino = realPath + fileName;
		logo.transferTo(new File(destino));
		return urlPath.getfileSaverPath() + fileName;
	}

	private static String getRealPath(HttpServletRequest request, String destino) {
		return request.getServletContext().getRealPath(destino);
	}

	private static void createFolder(String path) {
		File dir = new File(path);
		if (!dir.exists())
			dir.mkdirs();
	}
}
