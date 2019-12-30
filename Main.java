import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.zip.GZIPInputStream;

public class Main {

    static String input = "加密dex文件名";
    static String output = input + ".dex";

    public static void main(String[] args) {
        try {
            byte[] bArr = new byte[2048];
            InputStream open = new FileInputStream(input);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            open.available();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(output, true), 1024);
            while (true) {
                int read = open.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.close();
            byte[] c2 = c(a(byteArrayOutputStream.toByteArray(), "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"));
            if (c2 != null) {
                bufferedOutputStream.write(c2);
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
        }

    }

    public static byte[] c(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream v3 = new ByteArrayOutputStream();
        try {
            ByteArrayInputStream v2 = new ByteArrayInputStream(bytes);
            GZIPInputStream v4 = new GZIPInputStream(v2);
            byte[] r1 = new byte[0x4b000];
            int r5 = v4.read(r1);
            while (r5 >= 0) {
                v3.write(r1, 0, r5);
                r5 = v4.read(r1);
            }
            return v3.toByteArray();
        } catch (Exception e) {
            return null;
        }

    }

    public static byte[] a(byte[] bArr, String str) {
        byte[] a2 = a(bArr, str, 2);
        return a2;
    }

    public static byte[] a(byte[] bArr, String str, int i) {
        if (i != 1 && i != 2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("wrong mode.");
            throw illegalArgumentException;
        } else if (bArr == null || bArr.length == 0) {
            byte[] bArr2 = f170b;
            return bArr2;
        } else {
            try {
                Cipher a2 = a(str, i);
                if (a2 == null) {
                    byte[] bArr3 = f170b;
                    return bArr3;
                }
                byte[] doFinal = a2.doFinal(bArr);
                return doFinal;
            } catch (Throwable th) {
                byte[] bArr4 = f170b;
                return bArr4;
            }
        }
    }

    public static final byte[] f169a = {84, 101, 110, 99, 101, 110, 116, 76, 111, 99, 97, 116, 105, 111, 110, 49};
    public static final byte[] f170b = new byte[0];


    public static Cipher a(String str, int i) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(i, secretKeySpec, new IvParameterSpec(f169a));
        return instance;
    }

}
