package pageui;

public class ManufacturingDetailPageUI {
    public static final String MANUFACTURING_ORDER_VALUE = "//span[@placeholder='Manufacturing Reference']";
    public static final String PRODUCT_NAME_VALUE = "//label[text()='Product']/parent::td/following-sibling::td//a";
    public static final String QUANTITY_VALUE = "//span[@name='product_uom_id']";
    public static final String CONFIRM_BUTTON = "//button[@name='action_confirm']";
    public static final String MARK_AS_DONE_BUTTON = "(//button[@name='button_mark_done' and contains(@confirm,'to continue')])[2]";
    public static final String CONFIRM_OK_BUTTON = "//footer[@class='modal-footer']//button[contains(@class,'btn-primary')]";
    public static final String CONFIRM_APPLY_BUTTON = "//footer[@class='modal-footer']//button[contains(@class,'btn-primary')]";
    public static final String DONE_STATUS = "//div[@class='o_Message_trackingValue']//div[text()='Done']";
    public static final String MANUFACTURING_MENU = "//a[text()='Manufacturing']";
    public static final String QUANTITY_SALE_VALUE = "//span[@name='product_qty']";




}
