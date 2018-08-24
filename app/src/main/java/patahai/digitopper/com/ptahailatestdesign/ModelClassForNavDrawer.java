package patahai.digitopper.com.ptahailatestdesign;

public class ModelClassForNavDrawer {

    private String menuItemTitle;
    private Integer menuItemIcon;

    public ModelClassForNavDrawer(String menuItemTiele, Integer menuItemIcon) {
        this.menuItemTitle = menuItemTiele;
        this.menuItemIcon = menuItemIcon;
    }

    public String getMenuItemTitle() {
        return menuItemTitle;
    }

    public void setMenuItemTitle(String menuItemTiele) {
        this.menuItemTitle = menuItemTiele;
    }

    public Integer getMenuItemIcon() {
        return menuItemIcon;
    }

    public void setMenuItemIcon(Integer menuItemIcon) {
        this.menuItemIcon = menuItemIcon;
    }
}
