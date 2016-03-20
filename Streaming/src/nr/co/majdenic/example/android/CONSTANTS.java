package nr.co.majdenic.example.android;

import nr.co.majdenic.streaming.streamStation.StreamStation;



/**
 * @author rootlicker http://speakingcode.com
 *
 */
public class CONSTANTS {
    public static final String DUBSTEP_HQ_URL    = "http://lemon.citrus3.com:8062";
    public static final String DUBSTEP_LQ_URL    = "http://lemon.citrus3.com:8048";
    public static final String DNB_HQ_URL        = "http://lemon.citrus3.com:8144";
    public static final String GRIME_HQ_URL      = "http://lemon.citrus3.com:8120";
 
    public static final String DUBSTEP_HQ_LABEL  = "FILTH.FM Dubstep Hi-Fi (192kb/s)";
    public static final String DUBSTEP_LQ_LABEL  = "FILTH.FM Dubstep Lo-Fi (96kb/s)";
    public static final String DNB_HQ_LABEL      = "FILTH.FM D&B Hi-Fi (192kb/s)";
    public static final String GRIME_HQ_LABEL    = "FILTH.FM Grime Hi-Fi (192kb/s)";
    public static final StreamStation[] STATIONS =
        {
            new StreamStation(DUBSTEP_HQ_LABEL, DUBSTEP_HQ_URL),
            new StreamStation(DUBSTEP_LQ_LABEL, DUBSTEP_LQ_URL),
            new StreamStation(DNB_HQ_LABEL, DNB_HQ_URL),
            new StreamStation(GRIME_HQ_LABEL, GRIME_HQ_URL)
        };
    public static final StreamStation DEFAULT_STREAM_STATION = STATIONS[0];
}
