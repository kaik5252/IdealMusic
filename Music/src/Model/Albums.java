package Model;

/**
 * @author Kaik D' Andrade
 */
public final class Albums {

    private int alid;
    private String alname;
    private String alartist;

    public Albums(int id, String name, String artist) {
        setAlid(id);
        setAlname(name);
        setAlartist(artist);
    }
    
    public void createAlbum() {
        
    }
    
    public void updateAlbum() {
    
    }
    
    public void deleteAlbum() {
    
    }
    
    /**
     * @return the id
     */
    public int getAlid() {
        return alid;
    }

    /**
     * @param id the id to set
     */
    public void setAlid(int id) {
        this.alid = id;
    }

    /**
     * @return the name
     */
    public String getAlname() {
        return alname;
    }

    /**
     * @param name the name to set
     */
    public void setAlname(String name) {
        if (name.trim().equals("")) {
            this.alname = null;
        } else {
            this.alname = name;
        }
    }

    /**
     * @return the artist
     */
    public String getAlartist() {
        return alartist;
    }

    /**
     * @param artist the artist to set
     */
    public void setAlartist(String artist) {
        this.alartist = artist;
    }

}
