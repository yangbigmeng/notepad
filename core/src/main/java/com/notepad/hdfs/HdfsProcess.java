package com.notepad.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;

/**
 * Description: Hdfs远程访问示例
 * <p>
 * Create:       2018/6/21 23:59
 *
 * @author Marvin Yang
 */
public class HdfsProcess {

    /**
     * 构造FileSystem
     *
     * @return true, 构造成果
     * @throws Exception 构造异常
     */
    public boolean load() throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        fileSystem = FileSystem.get(new URI(HDFS_URI), conf, USER);
        return fileSystem != null;
    }

    /**
     * 根据指定的hdfs路径创建hdfs目录
     *
     * @param hdfsDir 指定的hdfs目录
     * @return true, hdfs目录构造完成
     * @throws Exception 构造异常
     */
    public boolean makeDir(Path hdfsDir) throws Exception {
        return fileSystem.exists(hdfsDir) || fileSystem.mkdirs(hdfsDir);
    }

    /**
     * 本地文件存储到hdfs目录
     *      示例:
     *          String localFile = "D:\\log\\text.demo";
     *          String hdfsDir = "/test/";
     *
     *          // 存储为hdfs://xxx/test/text.demo
     *          put(localFile, hdfsDir);
     *
     * @param localFile 本地文件路径
     * @param hdfsDir hdfs目录
     * @return true, 存储
     * @throws Exception 导入异常
     */
    public boolean put(String localFile, String hdfsDir) throws Exception {
        if (!makeDir(new Path(hdfsDir))) {
            return false;
        }
        File local = new File(localFile);
        if (!local.isFile()) {
            return false;
        }
        fileSystem.copyFromLocalFile(new Path(localFile), new Path(hdfsDir + "/" + local.getName()));
        return true;
    }

    /**
     * hdfs目录的文件存储到本地
     *      示例:
     *          String localDir = "D:\\log\\";
     *          String fileName = "text.demo";
     *          String hdfsDir = "/test/";
     *
     *          //将hdfs://xxx/test/text.demo存储到本地D:\\log\\
     *          get(hdfsDir, fileName, localDir);
     *
     * @param hdfsDir hdfs目录
     * @param fileName 指定文件
     * @param localDir 本地目录
     * @return true, 存储正常
     * @throws Exception 存储异常
     */
    public boolean get(String hdfsDir, String fileName, String localDir) throws Exception {
        InputStream in = fileSystem.open(new Path(hdfsDir + "/" + fileName));
        FileOutputStream out = new FileOutputStream(new File(localDir + "/" + fileName));
        IOUtils.copyBytes(in, out, 2048, true);
        return true;
    }

    private FileSystem fileSystem;
    private static final String HDFS_URI = "hdfs://{host}:{port}/";
    private static final String USER = "hdfs";
}
