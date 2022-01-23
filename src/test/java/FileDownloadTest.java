import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownloadTest extends BaseTest {

    public static final String TEST_FILE_NAME = "myFile.txt";
    File[] listOfFiles;

    @Test
    public void downloadFileTest() throws InterruptedException {
        fileDownloadPage.open();
        fileDownloadPage.isPageLoaded();
        fileDownloadPage.downloadFileTest(TEST_FILE_NAME);

        boolean found = false;
        for (int i = 0; i < 10; i++) {
            //List the files on that folder
            listOfFiles = folder.listFiles();
            File f = null;
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    String fileName = listOfFile.getName();
                    System.out.println("File " + listOfFile.getName());
                    if (fileName.matches(TEST_FILE_NAME)) {
                        f = new File(fileName);
                        found = true;
                    }
                }
            }
            if (found) {
                break;
            }
            Thread.sleep(1000);
        }
        Assert.assertTrue(found, "Downloaded document is not found");
    }

    @AfterMethod
    public File[] deletion() {
        listOfFiles = folder.listFiles();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.getName().equals(TEST_FILE_NAME)) {
                listOfFile.delete();
            }
        }
        return listOfFiles;
    }
}
