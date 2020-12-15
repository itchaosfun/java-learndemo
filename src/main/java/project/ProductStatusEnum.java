package project;


/**
 * 产商品状态枚举类
 */
public enum ProductStatusEnum {

    //产商品状态 0-待发布；1-待审核；2-待使用；3-在用；4-被驳回；5-已注销
    TO_COMMIT("0", "待提交"),
    TO_AUDIT("1", "待审核"),
    TO_USE("2", "审核通过待使用"),
    IN_USE("3", "在用"),
    REJECT_TO_RECOMMIT("4", "审核驳回待重新提交"),
    CANCELED("5", "已注销"),

    ;

    private ProductStatusEnum(String status, String description) {
        this.status = status;
        this.description = description;
    }

    private String status;
    private String description;

    public String getStatus() {
        return status;
    }

    public void setStatus(String type) {
        this.status = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
