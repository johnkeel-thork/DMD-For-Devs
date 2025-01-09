import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ControllerExample extends AppCompatActivity {

    //A simple example on how to implement DMD Remote Controller Support
    //Our Remotes always send out a broadcast on key press and key release
    //You should register the broadcast listener on the Resume of your activity and unregister on pause
    //You can further improve the example by adding logic for long press / repeat

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Register the Remote Listener
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(remoteListener, new IntentFilter("com.thorkracing.wireddevices.keypress"),
                    Context.RECEIVER_EXPORTED);
        }
        else{
            registerReceiver(remoteListener, new IntentFilter("com.thorkracing.wireddevices.keypress"));
        }
    }


    @Override
    protected void onPause() {
        super.onPause();

        //Unregister the remote listener
        if (remoteListener != null) {
            try {
                unregisterReceiver(remoteListener);
            } catch (Exception ignore) {}
        }

    }

    private final BroadcastReceiver remoteListener = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction() != null &&
                    intent.getAction().equals("com.thorkracing.wireddevices.keypress")) {

                //When the key is pressed
                if (intent.hasExtra("key_press")){

                    int keyCode = intent.getIntExtra("key_press",0);

                    switch (keyCode){

                        //UP (Usually Map Pan or Menus Select Up)
                        case 19:
                            break;

                        //DOWN (Usually Map Pan or Menus Select Down)
                        case 20:
                            break;

                        //LEFT (Usually Map Pan or Menus Select Left)
                        case 21:
                            break;

                        //RIGHT (Usually Map Pan or Menus Select Right)
                        case 22:
                            break;

                        //ROUND BUTTON 1 (Usually Follow Location Toggle / Center Map)
                        case 66:
                            break;

                        //ROUND BUTTON 2 (Usually Cancel / Back / 3D Mode / Tilt)
                        case 111:
                            break;

                        //SWITCH IN (Usually Zoom In)
                        case 136:
                            break;

                        //SWITCH OUT (Usually Zoom out)
                        case 137:
                            break;

                    }
                }
                //When the key is released
                else if (intent.hasExtra("key_release")){

                    int keyCode = intent.getIntExtra("key_release",0);

                    switch (keyCode){

                        //UP (Usually Map Pan or Menus Select Up)
                        case 19:
                            break;

                        //DOWN (Usually Map Pan or Menus Select Down)
                        case 20:
                            break;

                        //LEFT (Usually Map Pan or Menus Select Left)
                        case 21:
                            break;

                        //RIGHT (Usually Map Pan or Menus Select Right)
                        case 22:
                            break;

                        //ROUND BUTTON 1 (Usually Follow Location Toggle / Center Map)
                        case 66:
                            break;

                        //ROUND BUTTON 2 (Usually Cancel / Back / 3D Mode / Tilt)
                        case 111:
                            break;

                        //SWITCH IN (Usually Zoom In)
                        case 136:
                            break;

                        //SWITCH OUT (Usually Zoom out)
                        case 137:
                            break;

                    }

                }

            }
        }
    };

}
