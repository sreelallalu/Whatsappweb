package scan.wahts.virus.w12;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.Toast;

import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    public boolean f458m;
    private XWalkView xWalkWebView;
    String f460q = "";
    boolean f461r = false;
    boolean f459p = false;
    private ValueCallback VCallback;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        xWalkWebView=(XWalkView)findViewById(R.id.xwalkWebView89);




      MainActivity.this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, true);
        this.VCallback = new C02491();
        xWalkWebView.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0");

        xWalkWebView.load("http://bit.ly/1yMlbtv", null);
        this.xWalkWebView.addJavascriptInterface(new c32145(), "appmini");

    }
    public class WebAppInterface {
        @JavascriptInterface
        public void callFunction(){
            // Do your Android Stuff here
        }
    }
    public boolean onCreateOptionsMenu(Menu paramMenu)
    {
        getMenuInflater().inflate(R.menu.onoption, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.user_ask_attachment:
                CreateFile();
                cafu1234();


                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
    private void CreateFile()
    {
        File localFile = new File(Environment.getExternalStorageDirectory().toString() + "/DCIM/WhatWeb");
        try
        {
            if (!localFile.exists()) {
                localFile.mkdir();
            }
            return;
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
    }
    public void cafu1234()
    {
        Bitmap localBitmap2 = null;
        Object localObject1 = new Date();
        DateFormat.format("yyyy-MM-dd_hh:mm:ss", (Date)localObject1);
        Object localObject2 = Environment.getExternalStorageDirectory().toString() + "/DCIM/WhatWeb/" + localObject1 + ".png";
        Toast.makeText(this, "Screenshot Saved in /DCIM/WhatWeb", Toast.LENGTH_SHORT).show();
        int i = 0;
        if (this.xWalkWebView != null)
        {
            localBitmap2 = null;
            i = 0;
        }
        try
        {
            Class.forName("org.xwalk.core.XWalkView");
            i = 1;

                try
                {
                    Bitmap localBitmap1 = Bitmap.createBitmap(this.xWalkWebView.getWidth(), this.xWalkWebView.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas localCanvas = new Canvas(localBitmap1);
                    this.xWalkWebView.draw(localCanvas);
                    Log.e("jj","suucc_opp");


                    localObject2 = new File((String)localObject2);
                    localObject1 = localBitmap2;
                    localBitmap2 = coo205x(this.xWalkWebView).getBitmap();
                    localObject1 = localBitmap2;
                    Object localObject3 = new FileOutputStream((File)localObject2);
                    localObject1 = localBitmap2;
                    localBitmap2.compress(Bitmap.CompressFormat.PNG, 85, (OutputStream)localObject3);
                    localObject1 = localBitmap2;
                    ((FileOutputStream)localObject3).flush();
                    localObject1 = localBitmap2;
                    ((FileOutputStream)localObject3).close();
                    localObject1 = localBitmap2;
                    localObject2 = ((File)localObject2).toString();
                    localObject1 = localBitmap2;
                    localObject3 = new MediaScannerConnection.OnScanCompletedListener()
                    {
                        public void onScanCompleted(String paramAnonymousString, Uri paramAnonymousUri)
                        {
                            // Log.i("ExternalStorage", "Scanned " + paramAnonymousString + ":");
                            // Log.i("ExternalStorage", "-> uri=" + paramAnonymousUri);
                        }
                    };
                    localObject1 = localBitmap2;
                    Log.e("jj","suucc");

                    MediaScannerConnection.scanFile(this, new String[] {(String) localObject2}, null, (MediaScannerConnection.OnScanCompletedListener)localObject3);
                    //return localBitmap2;
                }
                catch (Exception localException2)
                {
                    localException2.printStackTrace();

                }
                /*localException1 = localException1;
                localException1.printStackTrace();*/

        }
        catch (Exception localException1)
        {
            
        }
        if (i != 0) {
            localObject1 = localBitmap2;
        }








       // return localBitmap1;
    }

    private TextureView coo205x(ViewGroup paramViewGroup)
    {
        int j = paramViewGroup.getChildCount();
        int i = 0;
        while (i < j)
        {
            Object localObject = paramViewGroup.getChildAt(i);
            if ((localObject instanceof TextureView))
            {
                if (((View)localObject).getParent().getClass().toString().contains("XWalk")) {
                    return (TextureView)localObject;
                }
            }
            else if ((localObject instanceof ViewGroup))
            {
                localObject = coo205x((ViewGroup)localObject);
                if (localObject != null) {
                    return (TextureView)localObject;
                }
            }
            i += 1;
        }
        return null;
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
        if (this.xWalkWebView != null) {
            this.xWalkWebView.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
    }

    public void m486k()
    {
        Intent localIntent = new Intent("android.intent.action.MAIN");
        localIntent.addCategory("android.intent.category.HOME");
        localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(localIntent);
    }
    public void m484a(Context paramContexte, String paramString1, String paramString2, int paramInt)
    {
      Intent  paramContext = new Intent(paramContexte, MainActivity.class);
        paramContext.setAction("android.intent.action.MAIN");
        paramContext.addCategory("android.intent.category.LAUNCHER");
        paramContext.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
    }


  /*  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
        if (paramKeyEvent.getAction() == 0)
        {
            switch (paramInt)
            {
            }
            for (;;)
            {
                return true;
                if ((!f458m) || (this.f459p))
                {

                   m486k();
                    onBackPressed();
                }
                else
                {

                    this.xWalkWebView.evaluateJavascript("javascript:hccp();", this.VCallback);
                }
            }
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }*/


    public class c32145 {
        public c32145() {
        }

        @JavascriptInterface
        public void c235() {
        }

        @JavascriptInterface
        public void cff543() {
           f458m = true;
        }

        @JavascriptInterface
     /*   public void p3542(String paramString1, String paramString2) {
            if (MainActivity.this.f460q.length() == 0) {
                MainActivity.this.f460q = (paramString1 + ": " + paramString2);
                if (MainActivity.this.f461r) {
                    MainActivity.this.m484a(MainActivity.this, paramString1, paramString2, 0);
                }
            }
            else {

               MainActivity.this.f460q = (f460q + "\n" + paramString1 + ": " + paramString2);
                if (!MainActivity.this.f461r);
                MainActivity.this.m484a(MainActivity.this, "WhatWeb", MainActivity.this.f460q, 0);

            }

        }*/
        public void p3542(String paramString1, String paramString2)
        {
            if (MainActivity.this.f460q.length() == 0)
            {
                MainActivity.this.f460q = (paramString1 + ": " + paramString2);
                if (MainActivity.this.f461r) {
                    MainActivity.this.m484a(MainActivity.this, paramString1, paramString2, 0);
                }
            }
            do
            {

                StringBuilder localStringBuilder = new StringBuilder();
                MainActivity localMainActivity = MainActivity.this;
                localMainActivity.f460q = (localMainActivity.f460q + "\n" + paramString1 + ": " + paramString2);

            } while (!MainActivity.this.f461r);
            MainActivity.this.m484a(MainActivity.this, "WhatWeb", MainActivity.this.f460q, 0);
            return;
        }
    }



    class C02491
            implements ValueCallback
    {
        C02491() {}

        public void m185a(String paramString)
        {
            if (paramString.equals("\"is_closed\""))
            {
               m486k();
                return;
            }

            MainActivity.this.xWalkWebView.evaluateJavascript("javascript:ccp();", null);
        }

        public void onReceiveValue(Object paramObject)
        {
            m185a((String)paramObject);
        }
    }
}
