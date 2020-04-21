import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class ApiSignTest {

    private static final String APP_KEY = "appkey";
    private static final String TIMESTAMP = "timestamp";
    private static final String SIGN = "sign";
    private static final String TOKEN = "token";
    private static final String OS = "os";
    private static final String OS_VERSION = "osVersion";
    private static final String CHANNEL_ID = "channelId";
    private static final String CAR_CHAT_VERSION = "vchatVersion";

    private String mAppKey = "chexin-app";
    private String mCurrentToken;
    private String mOsVersion;
    private String mChannelId;
    private String mVChatVersion;
    private String mSecretKey;

    /**
     * 生成上汽接口签名
     * Md5 32位(服务名#版本号#应用KEY#时间#密钥)，示例
     * Md5 32位(/point/getPoint#1.1#h5-application#1553680156533#30123456)
     */
    public String generateSign(long time) {
        String serveName = "/vcconfig/clientInfo/getClientInfo";
        String orgSign = serveName + "#" + mAppKey + "#" + time + "#" + "4KYxRs9gLY";
        System.out.println("serverName = " + serveName + ", appKey = " + mAppKey + ", time = " + time + ", mSecretKey = " + "4KYxRs9gLY");
        return md532(orgSign);
    }

    /**
     * md532位
     */
    public String md532(String org) {
        StringBuilder buf = new StringBuilder();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update((org).getBytes(StandardCharsets.UTF_8));
            byte b[] = md5.digest();
            int i;
            for (byte aB : b) {
                i = aB;
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

}
