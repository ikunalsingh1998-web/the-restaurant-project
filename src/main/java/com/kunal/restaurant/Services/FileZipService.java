package com.kunal.restaurant.Services;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.springframework.stereotype.Service;

@Service
public class FileZipService {

    public void zipFile(String sourceFilePath, String zipFilePath) throws IOException {
        File sourceFile = new File(sourceFilePath);
        FileOutputStream fileOutputStream = new FileOutputStream(zipFilePath);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        zipFile(sourceFile, sourceFile.getName(), zipOutputStream);
        zipOutputStream.close();
        fileOutputStream.close();
    }

    private void zipFile(File fileToZip, String fileName, ZipOutputStream zipOutputStream) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
            	zipOutputStream.putNextEntry(new ZipEntry(fileName));
            	zipOutputStream.closeEntry();
            } else {
            	zipOutputStream.putNextEntry(new ZipEntry(fileName + "/"));
            	zipOutputStream.closeEntry();
            }
            File[] children = fileToZip.listFiles();
            for (File childFile : children) {
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOutputStream);
            }
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOutputStream.putNextEntry(zipEntry);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fileInputStream.read(buffer)) >= 0) {
        	zipOutputStream.write(buffer, 0, length);
        }
        fileInputStream.close();
    }
}
