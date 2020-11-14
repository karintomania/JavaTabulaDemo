package tablajava;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

import technology.tabula.ObjectExtractor;
import technology.tabula.Page;

public class Utils {
        public static Page getAreaFromFirstPage(String path, float top, float left, float bottom, float right) throws IOException {
        return getAreaFromPage(path, 1, top, left, bottom, right);
    }

    public static Page getAreaFromPage(String path, int page, float top, float left, float bottom, float right) throws IOException {
        return getPage(path, page).getArea(top, left, bottom, right);
    }

    public static Page getPage(String path, int pageNumber) throws IOException {
        ObjectExtractor oe = null;
        try {
            PDDocument document = PDDocument
                    .load(new File(path));
            oe = new ObjectExtractor(document);
            Page page = oe.extract(pageNumber);
            return page;
        } finally {
            if (oe != null)
                oe.close();
        }
    }
    
}
