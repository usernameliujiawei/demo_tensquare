package entity;

/**
 * 返回值工具类
 */
public class Result {

    private Boolean flag;
    private Integer code;
    private String message;
    private Object date;

    public Result() {
    }

    public Result(Boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
    public Result(Boolean flag, Integer code, String message,Object date) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.date = date;

    }
    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
