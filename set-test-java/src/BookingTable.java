import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BookingTable {

    public Integer booking(String selectedDate, Data[] data) {
        int mostTable = 0;
        int usedTable = 0;

        Data[] selectedData = selectDataWithDate(selectedDate, data);

        for (int i = 0 ; i < selectedData.length; i++){
            usedTable = checkTotalOfUsedTable(i, selectedData);
            mostTable = checkMostTableInGroup(mostTable, selectedData[i]);
        }
        int totalTable = usedTable > mostTable ? usedTable : mostTable;
        return totalTable;
    }

    public Data[] selectDataWithDate(String selectedDate, Data[] data) {
        ArrayList<Data> list = new ArrayList<Data>();

        for(int i = 0; i < data.length; i++){
            if (selectedDate.compareTo(data[i].getBookingDate()) == 0) {
                list.add(data[i]);
            }
        }

        Data[] selectedData = new Data[list.size()];
        selectedData = list.toArray(selectedData);
        selectedData = sortWithStartTime(selectedData);
        return selectedData;
    }

    public Data[] sortWithStartTime(Data[] selectedData) {
        Arrays.sort(selectedData, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.getStartTime().compareTo(o2.getStartTime());
            }
        });
        return selectedData;
    }

    public int checkTotalOfUsedTable(int index, Data[] selectedData) {
        int usedTable = 0;
        for (int i = 0; i <= index; i++) {
            if (isNotTimeOut(selectedData[i].getEndTime(), selectedData[index].getStartTime())) {
                usedTable += calculateTable(selectedData[i].getTotal());
            }
        }
        return usedTable;
    }

    public int checkMostTableInGroup(int mostTable, Data selectedData) {
        mostTable = mostTable > calculateTable(selectedData.getTotal()) ? mostTable : calculateTable(selectedData.getTotal());
        return mostTable;
    }

    public int calculateTable(int seat) {
        return seat % 4 > 0 ? (seat / 4) + 1 : seat / 4;
    }

    public boolean isNotTimeOut(String endTime, String target) {
        return endTime.compareTo(target) > 0;
    }

}
