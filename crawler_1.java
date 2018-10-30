import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class crawler_1 {
	public static void main(String[] args) throws IOException {
		// readFile();
		String path = "/home/jion1/crawlerData/data_contract1.xls";
		String url1 = "https://etherscan.io/address/";
		List<Contract> list1 = readExcel(path);
		System.out.println(list1.size());

		List<Map<String, String>> list2 = new ArrayList<Map<String, String>>();

		for (int i = 0; i < 400; i++) {
			Map<String, String> map = new HashMap<String, String>();
			String url = url1 + list1.get(i).getAddress() + "#code";
			System.out.println(url);
			String compiler = "compiler:" + list1.get(i).getCompiler();
			String balance = "balance:" + list1.get(i).getBalance();
			String txCount = "txCount:" + list1.get(i).getTxCount();
			String settings = "settings:" + list1.get(i).getSettings();
			String dateTime = "dateTime:" + list1.get(i).getDateTime();
			String code = "code:" + getData(url);
			String collection = "code:" + "\n" + code + "\n" + compiler + "\n" + balance + "\n" + txCount + "\n"
					+ settings + "\n" + dateTime;
			map.put("address:" + list1.get(i).getAddress() + "\n", collection);
//			System.out.println(map);
			
			String data = "address:" + list1.get(i).getAddress();
//			System.out.println(data);
			
			String filename = "";
			filename = i + ".txt";
			System.out.println(filename);
			File file = new File("/home/jion1/contract/contract103/" + filename);
			BufferedWriter bw = null;
			try {
//				String s = map.toString();
				bw = new BufferedWriter(new FileWriter(file));
				bw.write(data);
				bw.newLine();
				bw.write(compiler);
				bw.newLine();
				bw.write(code);
				bw.newLine();
				bw.write(balance);
				bw.newLine();
				bw.write(txCount);
				bw.newLine();
				bw.write(settings);
				bw.newLine();
				bw.write(dateTime);
				bw.flush();
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("done");
			System.out.println();
			list2.add(map);
		}
	}

	public static String getData(String url) throws IOException {
		String linkText = null;
		Document doc = Jsoup.connect(url)
				.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0")
				.timeout(600000).get();
		Elements links = doc.select("pre[class=js-sourcecopyarea]");
		for (Element link : links) {
			linkText = link.text();
		}
		return linkText;
	}

	public static void readFile() throws IOException {
		FileReader fr = new FileReader("D://contract.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		String[] arrs = null;
		while ((line = br.readLine()) != null) {
			arrs = line.split(",");
		}
		br.close();
		fr.close();
	}

	public static List<Contract> readExcel(String path) throws IOException {
		List<Contract> list = new ArrayList<Contract>();

		InputStream ExcelFileToRead = new FileInputStream(path);
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
		HSSFSheet sheet = wb.getSheetAt(0);
		System.out.println(sheet.getLastRowNum());
		HSSFRow row; // 

		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			Contract ct = new Contract();

			if (row == null) {
				continue;
			}

			int j = row.getFirstCellNum();

			ct.setAddress(row.getCell(j).toString());
			ct.setName(row.getCell(j + 1).toString());
			ct.setCompiler(row.getCell(j + 2).toString());
			ct.setBalance(row.getCell(j + 3).toString());
			ct.setTxCount(row.getCell(j + 4).toString());
			ct.setSettings(row.getCell(j + 5).toString());
			ct.setDateTime(row.getCell(j + 6).toString());

			list.add(ct);
		}
		return list;
	}
}
