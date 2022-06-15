package com.my.Th3Shield;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import com.bumptech.glide.Glide;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;

public class ProfileActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> data = new HashMap<>();
	private double n = 0;
	private double ni = 0;
	
	private LinearLayout linear1;
	private ScrollView vscroll3;
	private LinearLayout linear3;
	private LinearLayout linear2;
	private ImageView imageview2;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear25;
	private TextView textviewemail;
	private TextView textviewname;
	private EditText edittextname;
	private Button button1;
	private ImageView imageview1;
	private LinearLayout linear16;
	private LinearLayout linearearnings;
	private LinearLayout linearreferal;
	private LinearLayout linearpassword;
	private LinearLayout linearchangephone;
	private LinearLayout linear22;
	private LinearLayout linearlogout;
	private TextView textview9;
	private TextView textview10;
	private TextView textview12;
	private LinearLayout linear24;
	private EditText edittextpassword;
	private Button button2;
	private TextView textview17;
	private LinearLayout linear27;
	private EditText edittext2;
	private TextView textview14;
	private LinearLayout linear26;
	private EditText edittext1;
	private TextView textview13;
	
	private DatabaseReference fsb = _firebase.getReference("users");
	private ChildEventListener _fsb_child_listener;
	private FirebaseAuth fauth;
	private OnCompleteListener<AuthResult> _fauth_create_user_listener;
	private OnCompleteListener<AuthResult> _fauth_sign_in_listener;
	private OnCompleteListener<Void> _fauth_reset_password_listener;
	private OnCompleteListener<Void> fauth_updateEmailListener;
	private OnCompleteListener<Void> fauth_updatePasswordListener;
	private OnCompleteListener<Void> fauth_emailVerificationSentListener;
	private OnCompleteListener<Void> fauth_deleteUserListener;
	private OnCompleteListener<Void> fauth_updateProfileListener;
	private OnCompleteListener<AuthResult> fauth_phoneAuthListener;
	private OnCompleteListener<AuthResult> fauth_googleSignInListener;
	
	private SharedPreferences sp;
	private Intent intent = new Intent();
	private AlertDialog.Builder dialog;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.profile);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		vscroll3 = findViewById(R.id.vscroll3);
		linear3 = findViewById(R.id.linear3);
		linear2 = findViewById(R.id.linear2);
		imageview2 = findViewById(R.id.imageview2);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		linear25 = findViewById(R.id.linear25);
		textviewemail = findViewById(R.id.textviewemail);
		textviewname = findViewById(R.id.textviewname);
		edittextname = findViewById(R.id.edittextname);
		button1 = findViewById(R.id.button1);
		imageview1 = findViewById(R.id.imageview1);
		linear16 = findViewById(R.id.linear16);
		linearearnings = findViewById(R.id.linearearnings);
		linearreferal = findViewById(R.id.linearreferal);
		linearpassword = findViewById(R.id.linearpassword);
		linearchangephone = findViewById(R.id.linearchangephone);
		linear22 = findViewById(R.id.linear22);
		linearlogout = findViewById(R.id.linearlogout);
		textview9 = findViewById(R.id.textview9);
		textview10 = findViewById(R.id.textview10);
		textview12 = findViewById(R.id.textview12);
		linear24 = findViewById(R.id.linear24);
		edittextpassword = findViewById(R.id.edittextpassword);
		button2 = findViewById(R.id.button2);
		textview17 = findViewById(R.id.textview17);
		linear27 = findViewById(R.id.linear27);
		edittext2 = findViewById(R.id.edittext2);
		textview14 = findViewById(R.id.textview14);
		linear26 = findViewById(R.id.linear26);
		edittext1 = findViewById(R.id.edittext1);
		textview13 = findViewById(R.id.textview13);
		fauth = FirebaseAuth.getInstance();
		sp = getSharedPreferences("data", Activity.MODE_PRIVATE);
		dialog = new AlertDialog.Builder(this);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				button1.setVisibility(View.GONE);
				imageview1.setVisibility(View.VISIBLE);
				textviewname.setVisibility(View.VISIBLE);
				edittextname.setVisibility(View.GONE);
				
				fsb.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(data);
				sp.edit().putString("name", edittextname.getText().toString()).commit();
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittextname.setVisibility(View.VISIBLE);
				button1.setVisibility(View.VISIBLE);
				imageview1.setVisibility(View.GONE);
				textviewname.setVisibility(View.GONE);
			}
		});
		
		linear16.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
		linearearnings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), WalletActivity.class);
				startActivity(intent);
			}
		});
		
		linearreferal.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ReferralActivity.class);
				startActivity(intent);
			}
		});
		
		linearpassword.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				fauth.sendPasswordResetEmail(textviewemail.getText().toString()).addOnCompleteListener(_fauth_reset_password_listener);
			}
		});
		
		linearchangephone.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dialog.setTitle("Do you want to log out?");
				dialog.setMessage("save your login information");
				dialog.setPositiveButton("Save & logout", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FirebaseAuth.getInstance().signOut();
					}
				});
				dialog.setNegativeButton("No logout", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						sp.edit().remove("name").commit();
						sp.edit().remove("email").commit();
						sp.edit().remove("password").commit();
						FirebaseAuth.getInstance().signOut();
						intent.setClass(getApplicationContext(), UserAuthActivity.class);
						startActivity(intent);
						finish();
					}
				});
				dialog.create().show();
			}
		});
		
		linearlogout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dialog.setTitle("Do you want to Logout?");
				dialog.setMessage("Save your login info");
				dialog.setPositiveButton("save & logout", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						sp.edit().remove("name").commit();
						sp.edit().remove("email").commit();
						sp.edit().remove("password").commit();
					}
				});
				dialog.setNegativeButton("logout", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FirebaseAuth.getInstance().signOut();
						intent.setClass(getApplicationContext(), UserAuthActivity.class);
						startActivity(intent);
					}
				});
				dialog.create().show();
			}
		});
		
		textview10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ReferralActivity.class);
				startActivity(intent);
			}
		});
		
		textview12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				button1.setVisibility(View.GONE);
				imageview1.setVisibility(View.VISIBLE);
				textviewname.setVisibility(View.VISIBLE);
				edittextname.setVisibility(View.GONE);
				
				fsb.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(data);
				sp.edit().putString("name", edittextname.getText().toString()).commit();
			}
		});
		
		textview14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		edittext1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		textview13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		_fsb_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					textviewname.setText("".concat(_childValue.get("name").toString().concat("")));
					textviewemail.setText(sp.getString("email", ""));
					edittextpassword.setText(sp.getString("password", ""));
					edittextname.setText(_childValue.get("name").toString());
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("url").toString())).into(imageview2);
				}
				else {
					
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		fsb.addChildEventListener(_fsb_child_listener);
		
		fauth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		fauth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_fauth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_fauth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_fauth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				if (_success) {
					SketchwareUtil.showMessage(getApplicationContext(), "password reset link has been sent to your email.");
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "something went wrong please try again");
				}
			}
		};
	}
	
	private void initializeLogic() {
		edittextname.setVisibility(View.GONE);
		button1.setVisibility(View.GONE);
		linearpassword.setVisibility(View.GONE);
		imageview1.setVisibility(View.VISIBLE);
		imageview2.setVisibility(View.VISIBLE);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}