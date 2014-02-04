public class CassetteTape extends MusicMedia
{
    public CassetteTape(String title, String artist, String sku)
    {
        super(title, artist, sku);
    }
    
    public String getMediaType()
    {
        return "Cassette";
    }
    
    public String toString()
    {
        return "Cassette - " + getTitle() + " (" + getArtist() + ")";
    }
}
