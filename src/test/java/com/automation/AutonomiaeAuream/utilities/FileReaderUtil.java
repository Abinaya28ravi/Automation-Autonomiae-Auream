package com.automation.AutonomiaeAuream.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderUtil extends CommonPageObject {
    public String fileReaderMethod(String fileName) throws IOException {
        String filecontent="";
        String filecontentOne="";
        switch (fileName) {
            case "infoPanelContent":
                try {
                    FileReader reader = new FileReader("src/test/resources/JSON/infopagepaneldata.json");
                    BufferedReader bufferedReader = new BufferedReader(reader);

                    while ((filecontent = bufferedReader.readLine()) != null) {
                        filecontentOne=filecontentOne+filecontent+"\n";

                    }
                    reader.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
        return filecontentOne;

    }
}

