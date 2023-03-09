package Model;

/**
 * @author Kaik D' Andrade
 */
public final class Music {

    private int mid;
    private String mname;
    private String msound;
    private String mcategory;
    private String malbum;

    public Music(int mid, String mname, String msound, String mcategory, String malbum) {
        setMname(mname);
        setMsound(msound);
        setMcategory(mcategory);
        setMalbum(malbum);
    }

    public void createMusic() {
        new Database().createMusic(this);
    }
    
    public void updateMusic() {
    
    }
    
    public void deleteMusic() {
    
    }

    /**
     * @return the id
     */
    public int getMid() {
        return mid;
    }

    /**
     * @param mid the mid to set
     */
    public void setMid(int mid) {
        this.mid = mid;
    }

    /**
     * @return the mname
     */
    public String getMname() {
        return mname;
    }

    /**
     * @param mname the mname to set
     */
    public void setMname(String mname) {
        if (mname.trim().equals("")) {
            this.mname = null;

        } else {
            this.mname = mname;
        }
    }

    /**
     * @return the msound
     */
    public String getMsound() {
        return msound;
    }

    /**
     * @param msound the msound to set
     */
    public void setMsound(String msound) {
        if (msound.trim().equals("")) {
            this.msound = null;

        } else {
            this.msound = msound;
        }
    }

    /**
     * @return the mcategory
     */
    public String getMcategory() {
        return mcategory;
    }

    /**
     * @param mcategory the mcategory to set
     */
    public void setMcategory(String mcategory) {
        if (mcategory.trim().equals("")) {
            this.mcategory = null;

        } else {
            this.mcategory = mcategory;
        }
    }

    /**
     * @return the malbum
     */
    public String getMalbum() {
        return malbum;
    }

    /**
     * @param malbum the malbum to set
     */
    public void setMalbum(String malbum) {
        if (malbum.trim().equals("")) {
            this.malbum = null;

        } else {
            this.malbum = malbum;
        }
    }
}
