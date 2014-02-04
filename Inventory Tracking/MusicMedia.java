public class MusicMedia
{
    private String myTitle,
    myArtist,
    mySKU;
    public MusicMedia( String title, String artist, String sku )
    {
        myTitle = title;
        myArtist = artist;
        mySKU = sku;
    }
    
    public String getTitle()
    {
        return myTitle;
    }
    
    public String getArtist()
    {
        return myArtist;
    }
    
    public String getMediaType()
    {
        return "Unknown";
    }
    
    public String getSKU()
    {
        return mySKU;
    }
    
    public String toString()
    {
        return getTitle() + " (" + getArtist() + ")"; 
    }
}