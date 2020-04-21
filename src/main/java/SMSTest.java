
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SMSTest {

    public Long createPost(){
        String userid = "124186";
        int msgFmt = 8;
        String password = "639045245f1bb5f2a0e0d641b3b226c3";
        String message = "【车信】验证码 12345";
        String mobile = "13865687670";
        String charset = "utf-8";
        String ext = "";
        String param = null;
        try {
            param = String.format("userid=%s&passwordMd5=%s&msg_fmt=%s&message=%s&mobile=%s&ext=", userid, password, msgFmt, URLEncoder.encode(message, charset), mobile, ext);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 调用接口
        return HttpsUtil.sendPost("https://139.129.107.160:18085/sendsms.php", param);
    }
}
