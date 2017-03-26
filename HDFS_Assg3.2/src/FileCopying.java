

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class FileCopying {
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("Pass two arguments");
			System.exit(1);
		}

		String localSrc = "/home/acadgild/Hai.txt";
		String dst = "/home/acadgild/hadoop";

		InputStream in = new BufferedInputStream(new FileInputStream(localSrc));
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(dst), conf);
		OutputStream out = fs.create(new Path(dst));
		
		IOUtils.copyBytes(in, out, 4096, true);
	}
}

