
package com.anonplusradio.android;

import com.anonplusradio.audio.media.streamStation.StreamStation;

/**
 * @author Marko Majdeniæ
 *
 */
public class CONSTANTS {
	public static final String CHAT_URL				= "majdenic.weebly.com";
	public static final String CHAT_HOST			= "majdenic.weebly.com";
	public static final String CHAT_CHANNEL			= "#majdenic";
	public static final String SITE_URL				= "http://majdenic.weebly.com/";
	
	public static final String STREAM_1_URL			= "http://144.76.172.23:7022/";
	public static final String STREAM_2_URL			= "http://209.105.250.73:8502/stream.aac";
	public static final String STREAM_3_URL			= "http://s7.iqstreaming.com:9498";
	public static final String STREAM_4_URL			= "http://173.192.137.34:8050";

	
	public static final String STREAM_1_LABEL		= "Radio DM";
	public static final String STREAM_2_LABEL		= "Otvoreni";
	public static final String STREAM_3_LABEL		= "Narodni";
	public static final String STREAM_4_LABEL		= "Antena";

	public static final StreamStation[] ALL_STATIONS =
		{
			new StreamStation(STREAM_1_LABEL, STREAM_1_URL),
			new StreamStation(STREAM_2_LABEL, STREAM_2_URL),
			new StreamStation(STREAM_3_LABEL, STREAM_3_URL),
			new StreamStation(STREAM_4_LABEL, STREAM_4_URL)
		};
		
	public static final StreamStation DEFAULT_STREAM_STATION = ALL_STATIONS[0];
}
