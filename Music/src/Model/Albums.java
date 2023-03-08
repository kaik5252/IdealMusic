package Model;

/**
 * @author Kaik D' Andrade
 */
public final class Albums {

    private int id;
    private String name;
    private String artist;

    public Albums(int id, String name, String artist) {
        setId(id);
        setName(name);
        setArtist(artist);
    }
    
    public void createAlbum() {
        
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        if (name.trim().equals("")) {
            this.name = null;
        } else {
            this.name = name;
        }
    }

    /**
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @param artist the artist to set
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

}
