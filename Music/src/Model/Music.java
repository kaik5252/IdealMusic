package Model;

/**
 * @author Kaik D' Andrade
 */
public final class Music {

    private int id;
    private String name;
    private String sound;
    private String category;
    private String album;

    public Music(int id, String name, String sound, String category, String album) {
        setName(name);
        setSound(sound);
        setCategory(category);
        setAlbum(album);
    }

    public void createMusic() {
        new Database().createMusic(this);
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
     * @return the sound
     */
    public String getSound() {
        return sound;
    }

    /**
     * @param sound the sound to set
     */
    public void setSound(String sound) {
        if (sound.trim().equals("")) {
            this.sound = null;

        } else {
            this.sound = sound;
        }
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        if (category.trim().equals("")) {
            this.category = null;

        } else {
            this.category = category;
        }
    }

    /**
     * @return the album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * @param album the album to set
     */
    public void setAlbum(String album) {
        if (album.trim().equals("")) {
            this.album = null;

        } else {
            this.album = album;
        }
    }
}
