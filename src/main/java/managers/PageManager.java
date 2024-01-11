package managers;

import pages.FirstPage;
import pages.TablePage;

public class PageManager {
    private static PageManager pageManager;

    private FirstPage firstPage;

    private TablePage tablePage;

    private PageManager() {

    }

    public static PageManager getPageManager() {
        if (pageManager==null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public FirstPage getFirstPage() {
        if (firstPage==null) {
            firstPage = new FirstPage();
        }
        return firstPage;
    }

    public TablePage getTablePage() {
        if (tablePage==null) {
            tablePage = new TablePage();
        }
        return tablePage;
    }

}
