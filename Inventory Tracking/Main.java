import java.util.*;
public class Main
{
    public static void main( String[] args )
    {
        ArrayList<MusicMedia> catalog = MakeMusicCatalog(100);
        for (MusicMedia m : catalog)
            System.out.println(m);
    }
    
    public static ArrayList<MusicMedia> MakeMusicCatalog(int size)
    {
        String[] titles ={"Greatest Hits Volume 1","Greatest Hits Volume 2",
                          "The Best Of","Love Songs","The Early Years","The Later Years"};
        String[] artists ={"Michael Jackson","Eminem","The Beatles","Shania Twain","Limp Bizkit"};
        ArrayList<MusicMedia> a = new ArrayList<MusicMedia>();
        Random rn = new Random();
    
        for ( int i = 0 ; i < size ; i++ )
        {
            MusicMedia m;
            int mediatype = rn.nextInt( 3 );
            String title = titles[ rn.nextInt( titles.length ) ];
            String artist = artists[ rn.nextInt( artists.length ) ];
            String sku ="1234-"+ i;
            if ( mediatype == 0 )
                m = new CompactDisk( title, artist, sku );
            else if ( mediatype == 1 )
                m = new DigitalVideoDisk( title, artist, sku );
            else
                m = new CassetteTape( title, artist, sku );
            a.add( m );
        }
        return a;
    }
}
