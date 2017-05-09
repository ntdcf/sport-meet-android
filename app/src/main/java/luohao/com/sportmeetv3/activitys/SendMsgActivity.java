package luohao.com.sportmeetv3.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.google.gson.Gson;

import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.empty.User;
import luohao.com.sportmeetv3.service.BothService;
import luohao.com.sportmeetv3.service.LinkService;

public class SendMsgActivity extends AppCompatActivity {
    private WebView sendMsg;

    private String SendMsgWebView = LinkService.ADDRESS_API+"sendmsg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_msg);

        User user = new Gson().fromJson(getIntent().getStringExtra("info"), User.class);
        SendMsgWebView += "?user="+user.getId();

        sendMsg = (WebView) findViewById(R.id.send_msg_webview);
        WebSettings webSettings = sendMsg.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        sendMsg.loadUrl(SendMsgWebView);
        sendMsg.setWebChromeClient(new WebChromeClient());
    }
}
