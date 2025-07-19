import java.util.*;
import java.io.*;

// 기록 리스트를 관리하고 파일로 저장/불러오는 기능 제공
public class RecordManager {
    private List<Record<String>> records = new ArrayList<>();

    // 기록 추가
    public void addRecord(Record<String> r) {
        records.add(r);
    }

    // 전체 기록 반환
    public List<Record<String>> getAllRecords() {
        return records;
    }

    // 파일에 기록 저장
    public void saveToFile(String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        for (Record<String> r : records) {
            // CSV 형식으로 저장
            bw.write(r.getDate() + "," + r.getCategory() + "," + r.getContent() + "," + r.getFilePath());
            bw.newLine();
        }
        bw.close();
    }

    // 파일에서 기록 불러오기
    public void loadFromFile(String filename) throws IOException {
        records.clear(); // 기존 기록 제거
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            // 각 줄을 쉼표로 분리해서 객체로 재구성
            String[] parts = line.split(",", 4);
            if (parts.length == 4) {
                records.add(new Record<>(parts[0], parts[1], parts[2], parts[3]));
            }
        }
        br.close();
    }
}

