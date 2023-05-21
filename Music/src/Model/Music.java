package Model;

import java.util.ArrayList;

public class Music extends Database {

    public Music(String table) {
        super(table);
    }

    public boolean createMusic() {
        return false;
    }

    public ArrayList<Object[]> readMusicForAlbum(int alid, String[] fields) {
        ArrayList<Object[]> arrayDataAlbum = read("WHERE enalbum = ?", new Object[]{alid}, new String[]{"enmusic"}, "enclose");
        ArrayList<Object[]> resultList = new ArrayList<>();

        for (int i = 0; i < arrayDataAlbum.size(); i++) {
            ArrayList<Object[]> arrayDataMusic = read("WHERE mid = ?", new Object[]{arrayDataAlbum.get(i)[0]}, fields, null);
            resultList.addAll(arrayDataMusic);
        }
        return resultList;
    }

    public ArrayList<Object[]> readMusic(Object[] data, String[] results) {
        return read("WHERE musers = ?", data, results, null);
    }

    public ArrayList<Object[]> readMusic(int mid, String[] results) {
        return read("WHERE mid = ?", new Object[]{mid}, results, null);
    }

    public ArrayList<Object[]> readMusic(String aditional, Object[] data, String[] results) {
        return read(aditional, data, results, null);
    }

    public boolean updateMusic() {
        return false;
    }

    public boolean deleteMusic(int mid) {
        /*
    }
        Object[][] dataread();
        File file = new File(filePath);

        // Verificação se o arquivo existe antes de deletar
        if (file.exists()) {
            // Deletar o arquivo
            boolean deleted = file.delete();
            delete();
            delete();
         */
        return false;
    }
}
