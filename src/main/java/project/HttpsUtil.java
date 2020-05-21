package project;

import javax.net.ssl.*;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

public class HttpsUtil {


    /**
     * ��ָ�� URL ����POST����������
     *
     * @param url   ��������� URL
     * @param param ����������������Ӧ���� name1=value1&name2=value2 ����ʽ��
     * @return ������Զ����Դ����Ӧ���
     */
    public static Long sendPost(String url, String param) {
        String result = "";
        try {
            HttpsURLConnection
                    .setDefaultHostnameVerifier(new HostnameVerifier() {
                        public boolean verify(String hostname, SSLSession sslsession) {
                            return true;
                        }
                    });
            // ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, tm, new java.security.SecureRandom());

            // ������SSLContext�����еõ�SSLSocketFactory����     
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            // �򿪺�URL֮�������
            URL realUrl = new URL(url);
            HttpsURLConnection conn = (HttpsURLConnection) realUrl.openConnection();
            conn.setSSLSocketFactory(ssf);
            // ����ͨ�õ�����
            conn.setRequestMethod("POST");// �ύģʽ
            conn.setDoOutput(true);
            // �����������
            byte[] bypes = param.toString().getBytes();
            conn.getOutputStream().write(bypes);
            // ����BufferedReader����������ȡURL����Ӧ
            InputStream inStream = conn.getInputStream();
            result = new String(readInputStream(inStream));
//            System.out.println("-----result-----"+result);
        } catch (Exception e) {
            System.out.println("���� POST ��������쳣��" + e);
            e.printStackTrace();
        }
        return Long.parseLong(result);
    }

    /**
     * ���������ж�ȡ����
     *
     * @param inStream
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();// ��ҳ�Ķ���������
        outStream.close();
        inStream.close();
        return data;
    }
}
