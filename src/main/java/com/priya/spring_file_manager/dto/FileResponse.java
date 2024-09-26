package com.priya.spring_file_manager.dto;

public class FileResponse {
    private String fileName;
    private byte[] fileContent;

    public FileResponse(String fileName, byte[] fileContent) {
        this.fileName = fileName;
        this.fileContent = fileContent;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getFileContent() {
        return fileContent;
    }
}