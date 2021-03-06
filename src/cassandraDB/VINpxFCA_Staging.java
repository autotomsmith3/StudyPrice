package cassandraDB;

//It works on January 27, 2020
//Updated on January 27, 2020
//It works on January 27, 2020

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.utils.UUIDs;

import cig.CassandraConnection;

public class VINpxFCA_Staging {
	public static void SaveScratch(String pathfilename, String ScratchText) {
		try {
			// BufferedWriter out2 = new BufferedWriter(new FileWriter(dataDir+ "Acodes.txt", true)); //original OK
			BufferedWriter out2 = new BufferedWriter(new FileWriter(pathfilename, true));
			// out2.write("("+i+"): "+Acode+": ");
			// out2.write(i + ". " + Acode + ": "); //Original OK
			// out2.newLine();
			out2.write(ScratchText);
			out2.newLine();
			out2.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void getFCAInventory(int stylenum, ResultSet res, int totalStyle, String pathfilename) {
		String FCAInventoryTitle = "dealercode,vin,bodystyle,exteriorcolorcode,exteriorcolordescription5,make,model,optioncodes,stocknum,trimdescription10,upperlevelpackage,vehtype,year13";
		UUID id;
		String dealercode = "";
		String vin = "";
		String bodystyle = "";
		String exteriorcolorcode = "";
		String exteriorcolordescription = "";
		String make = "";
		String model = "";
		String optioncodes = "";
		String stocknum = "";
		String trimdescription = "";
		String upperlevelpackage = "";
		String vehtype = "";
		String year = "";

		Date lastmodified;
		String rowString = "";
		if (stylenum == 1) {
			System.out.println("");
			System.out.println("Start:" + stylenum);
			System.out.println(FCAInventoryTitle);
			SaveScratch(pathfilename, FCAInventoryTitle);
		}
		for (Row row : res) {
			// Integer.toString(currentDynamicValue.getJSONObject(i).getInt("groupId"));
//			id = row.getUUID("id");
//			dealercode = Integer.toString(row.getInt("dealercode"));
			dealercode = row.getString("dealercode");
			vin = row.getString("vin");
			bodystyle = row.getString("bodystyle");
			exteriorcolorcode = row.getString("exteriorcolorcode");
			exteriorcolordescription = row.getString("exteriorcolordescription");
			make = row.getString("make");
			model = row.getString("model");
			optioncodes = row.getString("optioncodes");
			stocknum = row.getString("stocknum");
			trimdescription = row.getString("trimdescription");
			upperlevelpackage = row.getString("upperlevelpackage");
			vehtype = row.getString("vehtype");
			year = row.getString("year");
//			xxx =row.getString("xxx");
//			xxx =row.getString("xxx");

//			
//			
//			imageid = row.getString("imageid");
//			filename = row.getString("filename");
//			type = row.getString("type");
//			background = row.getString("background");
//			size = row.getString("size");
//			carryover = row.getString("carryover");
//			year = Integer.toString(row.getInt("year"));
//			division = row.getString("division");
//			model = row.getString("model");
//			body = row.getString("body");
////			exactmatch = row.getString("exactmatch");
////			OEMTemp = row.getString("OEMTemp");
//			country = row.getString("country");
//			lastmodified = row.getTimestamp("lastmodified");

			rowString = row + "," + dealercode + "," + bodystyle + "," + exteriorcolorcode + ","
					+ exteriorcolordescription + "," + make + "," + model + "," + optioncodes + "," + stocknum + ","
					+ trimdescription + "," + model + "," + upperlevelpackage + "," + vehtype + "," + year;
			System.out.println(rowString);
			SaveScratch(pathfilename, rowString);
		}
		if (stylenum == totalStyle) {
			System.out.println("End!" + stylenum);
		}
	}

	public static void main(String[] args) {
		String serverIp = "10.100.64.63"; // nslookup LCOA-DVTP-XCA1.autodatacorp.org. Login: fcainventory_user, Ps: password, //LCOA-DVTP-XCA1 keyspace: fcainventory_user
//		String serverIp = "172.16.150.11"; //nslookup LCOA-DVTP-XCA1.autodatacorp.org. Login: fcainventory_user, Ps: password,  //LCOA-DVTP-XCA1 keyspace: fcainventory_user 
//		"172.16.150.11"  - nslookup LCOA-DVTP-XCA1.autodatacorp.org
//		"172.16.150.12"  - nslookup LCOA-DVTP-XCA2.autodatacorp.org
//		"172.16.150.13"  - nslookup LCOA-DVTP-XCA3.autodatacorp.org
//		"10.100.64.63" - nslookup pcoc-stfi-xca1.autodata.org
//		"10.100.64.64" - nslookup pcoc-stfi-xca2.autodata.org
//		
//		
//		pcoc-stfi-xca2.autodata.org/10.100.64.64:9042 -- what's this? don't know
//		Need to add below jars and dependency in porm.xml
//		 <dependency>
//         <groupId>com.datastax.cassandra</groupId>
//         <artifactId>cassandra-driver-core</artifactId>
//         <version>3.4.0</version>
//     </dependency>
//     <dependency>
//         <groupId>com.datastax.cassandra</groupId>
//         <artifactId>cassandra-driver-mapping</artifactId>
//         <version>3.4.0</version>
//     </dependency>
//     <dependency>
//         <groupId>com.datastax.cassandra</groupId>
//         <artifactId>cassandra-driver-extras</artifactId>
//         <version>3.4.0</version>
//     </dependency>
//     <dependency>
//         <groupId>org.slf4j</groupId>
//         <artifactId>slf4j-api</artifactId>
//         <version>1.7.25</version>
//     </dependency>
//     <dependency>
//         <groupId>org.slf4j</groupId>
//         <artifactId>slf4j-log4j12</artifactId>
//         <version>1.7.22</version>
//     </dependency>
//		
		String keyspace = "vdvi";
//		CassandraConnection connection;
//		Cluster cluster = Cluster.builder().addContactPoints(serverIp).build();
		Cluster cluster = Cluster.builder().addContactPoints(serverIp).withCredentials("fcainventory_user", "password")
				.build();// works
		Session session = cluster.connect(keyspace);// 20200123 passed
		String cqlStatement = "select * from vi01_fcadigital_inventory where dealercode='45685' allow filtering";//
		ResultSet results = session.execute(cqlStatement);

		String[] style = { "389544", "387896" };// { "389544", "387896","389544" };
		String datestring = "20200127";
		int styleLength = style.length;
		String colorpathfile = "C:\\1\\Eclipse\\Test Results\\FCA_CassandraStaging\\Staging_FCA_Inventory_" + datestring
				+ "_" + styleLength + ".txt";

		// ***************************Colormappings**************************
		for (int i = 0; i < styleLength; i++) {
//		 String cqlStatement = "select * from batch_processing_request_qa.batchrequest";// + style[i];
//		 ResultSet results = session.execute(cqlStatement);
			getFCAInventory(i + 1, results, styleLength, colorpathfile);
		}

		cluster.close();
	}
}