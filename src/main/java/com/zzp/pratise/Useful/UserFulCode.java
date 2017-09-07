package com.zzp.pratise.Useful;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.json.JSONException;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by zhuzhengping
 * on 2017/9/7.
 */
public class UserFulCode {

    public static void main(String[] args) throws ParseException {

//1. 字符串有整型的相互转换

        String a = String.valueOf(2);   //integer to numeric string
        int i = Integer.parseInt(a); //numeric string to an int

//2. 向文件末尾添加内容

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("filename", true));
            out.write("aString");
        } catch (IOException e) {
            // error processing code
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

//3. 得到当前方法的名字

        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

//4. 转字符串到日期

        Date date1 = java.text.DateFormat.getDateInstance().parse("date");
//或者是：

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = format.parse("MyString");

//6. 把 Java util.Date 转成 sql.Date

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

//9. 创建 JSON 格式的数据

        JSONObject json = new JSONObject();
        try {
            json.put("city", "Mumbai");
            json.put("country", "India");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String output = json.toString();

//11. HTTP 代理设置

        System.getProperties().put("http.proxyHost", "someProxyURL");
        System.getProperties().put("http.proxyPort", "someProxyPort");
        System.getProperties().put("http.proxyUser", "someUserName");
        System.getProperties().put("http.proxyPassword", "somePassword");

//14. 列出文件和目录

        File dir = new File("directoryName");
        String[] children = dir.list();
        if (children == null) {
            // Either dir does not exist or is not a directory
        } else {
            for (int index = 0; index < children.length; index++) {
                // Get filename of file or directory
                String filename = children[index];
            }
        }

        // It is also possible to filter the list of returned files.
        // This example does not return any files that start with `.'.
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return !name.startsWith(".");
            }
        };
        children = dir.list(filter);

        // The list of files can also be retrieved as File objects
        File[] files = dir.listFiles();

        // This filter only returns directories
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };
        files = dir.listFiles(fileFilter);
    }

//7. 使用NIO进行快速的文件拷贝

    public static void fileCopy(File in, File out )
            throws IOException
    {
        FileChannel inChannel = new FileInputStream( in ).getChannel();
        FileChannel outChannel = new FileOutputStream( out ).getChannel();
        try
        {
//          inChannel.transferTo(0, inChannel.size(), outChannel);      // original -- apparently has trouble copying large files on Windows

            // magic number for Windows, 64Mb - 32Kb)
            int maxCount = (64 * 1024 * 1024) - (32 * 1024);
            long size = inChannel.size();
            long position = 0;
            while ( position < size )
            {
                position += inChannel.transferTo( position, maxCount, outChannel );
            }
        }
        finally
        {
            if ( inChannel != null )
            {
                inChannel.close();
            }
            if ( outChannel != null )
            {
                outChannel.close();
            }
        }
    }

//8. 创建图片的缩略图

    private void createThumbnail(String filename, int thumbWidth, int thumbHeight, int quality, String outFilename)
            throws InterruptedException, FileNotFoundException, IOException
    {
        // load image from filename
        Image image = Toolkit.getDefaultToolkit().getImage(filename);
        MediaTracker mediaTracker = new MediaTracker(new Container());
        mediaTracker.addImage(image, 0);
        mediaTracker.waitForID(0);
        // use this to test for errors at this point: System.out.println(mediaTracker.isErrorAny());

        // determine thumbnail size from WIDTH and HEIGHT
        double thumbRatio = (double)thumbWidth / (double)thumbHeight;
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);
        double imageRatio = (double)imageWidth / (double)imageHeight;
        if (thumbRatio < imageRatio) {
            thumbHeight = (int)(thumbWidth / imageRatio);
        } else {
            thumbWidth = (int)(thumbHeight * imageRatio);
        }

        // draw original image to thumbnail image object and
        // scale it to the new size on-the-fly
        BufferedImage thumbImage = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = thumbImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);

        // save thumbnail image to outFilename
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFilename));
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(thumbImage);
        quality = Math.max(0, Math.min(quality, 100));
        param.setQuality((float)quality / 100.0f, false);
        encoder.setJPEGEncodeParam(param);
        encoder.encode(thumbImage);
        out.close();
    }

//13. 抓屏程序

    public void captureScreen(String fileName) throws Exception {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        ImageIO.write(image, "png", new File(fileName));

    }

//18. 发送邮件

    public void postMail( String recipients[ ], String subject, String message , String from) throws MessagingException, javax.mail.MessagingException {
        boolean debug = false;

        //Set the host smtp address
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.example.com");

        // create some properties and get the default Session
        javax.mail.Session session = javax.mail.Session.getDefaultInstance(props, null);
        session.setDebug(debug);

        // create a message
        Message msg = new MimeMessage(session);

        // set the from and to address
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);

        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++)
        {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        msg.setRecipients(Message.RecipientType.TO, addressTo);

        // Optional : You can also set your custom headers in the Email if you Want
        msg.addHeader("MyHeaderName", "myHeaderValue");

        // Setting the Subject and Content Type
        msg.setSubject(subject);
        msg.setContent(message, "text/plain");
        Transport.send(msg);
    }

}
