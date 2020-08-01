package com.quickfussion.challenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class MainActivity extends AppCompatActivity {
    private FrameLayout frameLayout;
    private ImageButton ibone, ibtwo, ibthree, ibfour;
    private FloatingActionButton floatingActionButton;
    private ImageView notificationimg;
    private ImageButton back,next;
    String viewname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Goals");
        frameLayout = findViewById(R.id.action_frame);
        floatingActionButton = findViewById(R.id.fab);
        ibfour = findViewById(R.id.ib4);
        ibthree = findViewById(R.id.ib3);
        ibtwo = findViewById(R.id.ib2);
        ibone = findViewById(R.id.ib1);
        notificationimg =findViewById(R.id.notification_badge);
        back = findViewById(R.id.backword);
        next = findViewById(R.id.forward);
        SpaceNavigationView spaceNavigationView = (SpaceNavigationView) findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("Dashboard", R.drawable.dashboard));
        spaceNavigationView.addSpaceItem(new SpaceItem("Profile", R.drawable.user));
        spaceNavigationView.shouldShowFullBadgeText(true);

        viewname = "ibone";
        setFragment(new Your_Info());
        updateView();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Fab button is clicked",Toast.LENGTH_SHORT).show();
            }
        });

        notificationimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Notification badge is clicked",Toast.LENGTH_SHORT).show();
            }
        });

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Toast.makeText(MainActivity.this,"Settings Clicked",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                if (itemIndex == 1) {
                    Toast.makeText(MainActivity.this,"Profile Clicked",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,"Dashboard Clicked",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewname.matches("ibone")){
                    viewname = "ibfour";
                    setFragment(new Your_Family());
                }else if(viewname.matches("ibtwo")){
                    viewname = "ibone";
                    setFragment(new Your_Info());
                }else if(viewname.matches("ibthree")){
                    viewname = "ibtwo";
                    setFragment(new Know_About_You());
                }else if(viewname.matches("ibfour")){
                    viewname = "ibthree";
                    setFragment(new Your_Risk());
                }
                updateView();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewname.matches("ibthree")){
                    viewname = "ibfour";
                    setFragment(new Your_Family());
                }else if(viewname.matches("ibfour")){
                    viewname = "ibone";
                    setFragment(new Your_Info());
                }else if(viewname.matches("ibone")){
                    viewname = "ibtwo";
                    setFragment(new Know_About_You());
                }else if(viewname.matches("ibtwo")){
                    viewname = "ibthree";
                    setFragment(new Your_Risk());
                }
                updateView();
            }
        });
        ibone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new Your_Info());
                viewname = "ibone";
                updateView();
            }
        });

        ibtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new Know_About_You());
                viewname ="ibtwo";
                updateView();
            }
        });

        ibthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new Your_Risk());
                viewname ="ibthree";
                updateView();
            }
        });

        ibfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new Your_Family());
                viewname = "ibfour";
                updateView();
            }
        });
    }
    void updateView() {
        if(viewname.matches("ibone")){
            ibone.setBackground(getResources().getDrawable(R.drawable.selected_view));
            ibtwo.setBackground(getResources().getDrawable(R.drawable.unselected_view));
            ibthree.setBackground(getResources().getDrawable(R.drawable.unselected_view));
            ibfour.setBackground(getResources().getDrawable(R.drawable.unselected_view));
        }else if(viewname.matches("ibtwo")){
            ibtwo.setBackground(getResources().getDrawable(R.drawable.selected_view));
            ibone.setBackground(getResources().getDrawable(R.drawable.unselected_view));
            ibthree.setBackground(getResources().getDrawable(R.drawable.unselected_view));
            ibfour.setBackground(getResources().getDrawable(R.drawable.unselected_view));
        }else if(viewname.matches("ibthree")){
            ibthree.setBackground(getResources().getDrawable(R.drawable.selected_view));
            ibtwo.setBackground(getResources().getDrawable(R.drawable.unselected_view));
            ibone.setBackground(getResources().getDrawable(R.drawable.unselected_view));
            ibfour.setBackground(getResources().getDrawable(R.drawable.unselected_view));
        }else if(viewname.matches("ibfour")){
            ibfour.setBackground(getResources().getDrawable(R.drawable.selected_view));
            ibtwo.setBackground(getResources().getDrawable(R.drawable.unselected_view));
            ibthree.setBackground(getResources().getDrawable(R.drawable.unselected_view));
            ibone.setBackground(getResources().getDrawable(R.drawable.unselected_view));
        }
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}