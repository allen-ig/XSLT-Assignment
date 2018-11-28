package xml.assignment;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class transformer {

	public static void main(String args[]) {

		String XSLFILE="";
		String INFILE="";
		String OUTFILE="";

		try {

			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			if(args.length == 3) {
				XSLFILE = args[0];
				INFILE = args[1];
				OUTFILE = args[2];
			}
			else {
				System.out.println("Please enter the path to XSL file");
			/*	XSLFILE = br.readLine();
				System.out.println("Please enter the path to Input XML file");
				INFILE = br.readLine();
				System.out.println("Please enter the path for Output file");
				OUTFILE = br.readLine(); */
			}

			StreamSource xslcode = new StreamSource(new File(XSLFILE));
			StreamSource input = new StreamSource(new File(INFILE));
			StreamResult output = new StreamResult(new File(OUTFILE));

			TransformerFactory tf =TransformerFactory.newInstance();

			Transformer trans = tf.newTransformer(xslcode);

			trans.transform(input, output);
			
			System.out.println("Output file ready");


		} catch ( TransformerException e) {
			e.printStackTrace();
		}

	}
}
