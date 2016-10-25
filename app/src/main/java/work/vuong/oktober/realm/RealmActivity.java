package work.vuong.oktober.realm;

import android.os.Bundle;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

import io.realm.Credentials;
import io.realm.ObjectServerError;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;
import io.realm.SyncConfiguration;
import io.realm.User;
import work.vuong.oktober.R;

public class RealmActivity extends AppCompatActivity {

    //TODO: Hack me all you want github users ;)
    public static final String AUTHENTICATION_URL = "http://128.199.53.123:9080/auth";
    public static final String REALM_URL = "realm://128.199.53.123:9080/~/items";
    private EditText editText;
    private RecyclerView recyclerView;
    private Button addButton;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);

        //Yes I didn't use butterknife or databinding.
        editText = (EditText) findViewById(R.id.editText);
        addButton = (Button) findViewById(R.id.button);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAttendant();
            }
        });

        //if your user doesn't exist yet set to true.
        User.loginAsync(Credentials.usernamePassword("Test", "Test123", false), AUTHENTICATION_URL, new User.Callback() {
            @Override
            public void onSuccess(User user) {
                setupRealm(user);
                realm = Realm.getDefaultInstance();
                saveLoginLog();
                setupAdapter();
            }

            @Override
            public void onError(ObjectServerError error) {
                error.printStackTrace();
            }
        });
    }

    private void addAttendant() {
        String text = editText.getText().toString();

        if (TextUtils.isEmpty(text)){
            Toast.makeText(this, "Duude its empty?", Toast.LENGTH_SHORT).show();
            return;
        }
        //Used a different way of adding on purpose :)
        int id = 0;
        if (!realm.where(Attendants.class).findAll().isEmpty()){
            id = getIncrementId(realm, Attendants.class);
        }
        final Attendants geek = new Attendants();
        geek.setName(text);
        geek.setId(id);
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(geek);
            }
        });

        editText.setText("");
    }

    @Override
    protected void onPause() {
        super.onPause();
        realm.close();
    }

    private void setupAdapter() {
        RealmResults<Attendants> all = realm.where(Attendants.class)
                .findAll();

        recyclerView.setAdapter(new TextAdapter(this, all, true));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void saveLoginLog() {
        final LoginLog log = new LoginLog();
        log.setTimestamp(new Date());
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (!realm.isEmpty()) {
                    //increment IDs
                    log.setId(getIncrementId(realm, LoginLog.class));
                }
                realm.copyToRealm(log);
            }
        });
    }

    private static int getIncrementId(Realm realm, Class<? extends RealmObject> clazz) {
        return realm.where(clazz).max("id").intValue() + 1;
    }

    private void setupRealm(User user) {
        SyncConfiguration defaultConfig = new SyncConfiguration.Builder(user, REALM_URL).build();
        Realm.setDefaultConfiguration(defaultConfig);
    }
}