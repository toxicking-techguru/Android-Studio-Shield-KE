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
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;

public class UserAuthActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> data = new HashMap<>();
	private HashMap<String, Object> data1 = new HashMap<>();
	
	private LinearLayout linear8;
	private ImageView imageview4;
	private ImageView imageview7;
	private ImageView imageview10;
	private ScrollView vscroll6;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private LinearLayout linearname;
	private LinearLayout linearemail;
	private LinearLayout linearphone;
	private LinearLayout linearpassword;
	private LinearLayout linear49;
	private TextView textviewheader;
	private Button buttonlogin;
	private Button buttonsighnup;
	private TextView textviewname;
	private LinearLayout linear43;
	private ImageView imageview12;
	private EditText edittextname;
	private TextView textviewemail;
	private LinearLayout linear45;
	private ImageView imageview13;
	private EditText edittextemail;
	private TextView textviewphone;
	private LinearLayout linear47;
	private ImageView imageview14;
	private EditText edittextphone;
	private TextView textviewpassword;
	private LinearLayout linear48;
	private ImageView imageview15;
	private EditText edittextpassword;
	private ImageView imageviewshow;
	private ImageView imageviewhide;
	private LinearLayout linearloading;
	private Button login;
	private Button sighnup;
	private Button sendlink;
	private TextView textviewforgot;
	private ProgressBar progressbar1;
	private TextView textview1;
	
	private DatabaseReference fdb = _firebase.getReference("users");
	private ChildEventListener _fdb_child_listener;
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
	
	private Intent i = new Intent();
	private SharedPreferences sp;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.user_auth);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear8 = findViewById(R.id.linear8);
		imageview4 = findViewById(R.id.imageview4);
		imageview7 = findViewById(R.id.imageview7);
		imageview10 = findViewById(R.id.imageview10);
		vscroll6 = findViewById(R.id.vscroll6);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		linear12 = findViewById(R.id.linear12);
		linearname = findViewById(R.id.linearname);
		linearemail = findViewById(R.id.linearemail);
		linearphone = findViewById(R.id.linearphone);
		linearpassword = findViewById(R.id.linearpassword);
		linear49 = findViewById(R.id.linear49);
		textviewheader = findViewById(R.id.textviewheader);
		buttonlogin = findViewById(R.id.buttonlogin);
		buttonsighnup = findViewById(R.id.buttonsighnup);
		textviewname = findViewById(R.id.textviewname);
		linear43 = findViewById(R.id.linear43);
		imageview12 = findViewById(R.id.imageview12);
		edittextname = findViewById(R.id.edittextname);
		textviewemail = findViewById(R.id.textviewemail);
		linear45 = findViewById(R.id.linear45);
		imageview13 = findViewById(R.id.imageview13);
		edittextemail = findViewById(R.id.edittextemail);
		textviewphone = findViewById(R.id.textviewphone);
		linear47 = findViewById(R.id.linear47);
		imageview14 = findViewById(R.id.imageview14);
		edittextphone = findViewById(R.id.edittextphone);
		textviewpassword = findViewById(R.id.textviewpassword);
		linear48 = findViewById(R.id.linear48);
		imageview15 = findViewById(R.id.imageview15);
		edittextpassword = findViewById(R.id.edittextpassword);
		imageviewshow = findViewById(R.id.imageviewshow);
		imageviewhide = findViewById(R.id.imageviewhide);
		linearloading = findViewById(R.id.linearloading);
		login = findViewById(R.id.login);
		sighnup = findViewById(R.id.sighnup);
		sendlink = findViewById(R.id.sendlink);
		textviewforgot = findViewById(R.id.textviewforgot);
		progressbar1 = findViewById(R.id.progressbar1);
		textview1 = findViewById(R.id.textview1);
		fauth = FirebaseAuth.getInstance();
		sp = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		linear10.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)10, 0xFFFFB74D, 0xFFFFECB3));
				return true;
			}
		});
		
		buttonlogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				buttonlogin.setVisibility(View.GONE);
				sighnup.setVisibility(View.GONE);
				sendlink.setVisibility(View.GONE);
				linearname.setVisibility(View.GONE);
				linearphone.setVisibility(View.GONE);
				textviewheader.setText("login");
				buttonsighnup.setVisibility(View.VISIBLE);
				linearname.setVisibility(View.GONE);
				linearpassword.setVisibility(View.VISIBLE);
				login.setVisibility(View.VISIBLE);
				textviewforgot.setVisibility(View.VISIBLE);
			}
		});
		
		buttonsighnup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				login.setVisibility(View.GONE);
				sendlink.setVisibility(View.GONE);
				buttonsighnup.setVisibility(View.GONE);
				textviewforgot.setVisibility(View.GONE);
				buttonlogin.setVisibility(View.VISIBLE);
				sighnup.setVisibility(View.VISIBLE);
				linearemail.setVisibility(View.VISIBLE);
				linearname.setVisibility(View.VISIBLE);
				linearpassword.setVisibility(View.VISIBLE);
				linearphone.setVisibility(View.VISIBLE);
				textviewheader.setText("sign up");
			}
		});
		
		textviewphone.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		edittextphone.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		imageviewshow.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageviewshow.setVisibility(View.GONE);
				imageviewhide.setVisibility(View.VISIBLE);
				edittextpassword.setTransformationMethod(android.text.method.HideReturnsTransformationMethod.getInstance());
			}
		});
		
		imageviewhide.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageviewshow.setVisibility(View.VISIBLE);
				imageviewhide.setVisibility(View.GONE);
				edittextpassword.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
			}
		});
		
		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittextemail.getText().toString().equals("") || edittextpassword.getText().toString().equals("")) {
					if (edittextemail.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "please enter your email");
					}
					if (edittextpassword.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "please enter your password");
					}
				}
				else {
					if (!edittextemail.getText().toString().contains("gmail.com")) {
						SketchwareUtil.showMessage(getApplicationContext(), "please enter your valid email");
					}
					else {
						fauth.signInWithEmailAndPassword(edittextemail.getText().toString(), edittextpassword.getText().toString()).addOnCompleteListener(UserAuthActivity.this, _fauth_sign_in_listener);
						linearloading.setVisibility(View.VISIBLE);
					}
				}
			}
		});
		
		sighnup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittextname.getText().toString().equals("") || (edittextemail.getText().toString().equals("") || (edittextphone.getText().toString().equals("") || edittextpassword.getText().toString().equals("")))) {
					if (edittextname.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "please enter your name");
					}
					if (edittextemail.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "please enter your email");
					}
					if (edittextphone.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "please enter your phone number");
					}
					if (edittextpassword.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "please enter your password");
					}
				}
				else {
					if (!(Double.parseDouble(edittextphone.getText().toString()) < 6099999999d) || !edittextemail.getText().toString().contains("gmail.com")) {
						if (!(Double.parseDouble(edittextphone.getText().toString()) < 6099999999d)) {
							SketchwareUtil.showMessage(getApplicationContext(), "please enter a valid phone number");
						}
						if (!edittextemail.getText().toString().contains("gmail.com")) {
							SketchwareUtil.showMessage(getApplicationContext(), "enter a valid  email");
						}
					}
					else {
						fauth.createUserWithEmailAndPassword(edittextemail.getText().toString(), edittextpassword.getText().toString()).addOnCompleteListener(UserAuthActivity.this, _fauth_create_user_listener);
						linearloading.setVisibility(View.VISIBLE);
					}
				}
			}
		});
		
		sendlink.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittextemail.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "please enter your email");
				}
				else {
					if (edittextemail.getText().toString().contains("gmail.com")) {
						fauth.sendPasswordResetEmail(edittextemail.getText().toString()).addOnCompleteListener(_fauth_reset_password_listener);
						linearloading.setVisibility(View.VISIBLE);
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "please enter your valid email");
					}
				}
			}
		});
		
		textviewforgot.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
		textviewforgot.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				buttonsighnup.setVisibility(View.GONE);
				sighnup.setVisibility(View.GONE);
				login.setVisibility(View.GONE);
				linearname.setVisibility(View.GONE);
				linearphone.setVisibility(View.GONE);
				linearpassword.setVisibility(View.GONE);
				textviewforgot.setVisibility(View.GONE);
				linearemail.setVisibility(View.VISIBLE);
				buttonlogin.setVisibility(View.VISIBLE);
				sendlink.setVisibility(View.VISIBLE);
				textviewheader.setText("forgot password?");
			}
		});
		
		_fdb_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					textviewname.setText("".concat(_childValue.get("name").toString().concat("")));
					textviewemail.setText("");
					textviewemail.setText(sp.getString("", ""));
					edittextpassword.setText(sp.getString("", ""));
					edittextname.setText(_childValue.get("name").toString());
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
		fdb.addChildEventListener(_fdb_child_listener);
		
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
				if (_success) {
					linearloading.setVisibility(View.GONE);
					data.put("name", edittextname.getText().toString());
					data.put("email", edittextemail.getText().toString());
					data.put("mobile", edittextphone.getText().toString());
					data.put("password", edittextpassword.getText().toString());
					data.put("count", "0");
					data.put("profile", "");
					data.put("referral", "0");
					data1.put(FirebaseAuth.getInstance().getCurrentUser().getUid(), "");
					//code for verification link send on user email
					
					fauth.getCurrentUser().sendEmailVerification() .addOnCompleteListener(new OnCompleteListener<Void>() {
						@Override
						public void onComplete(Task<Void> task) {
							if (task.isSuccessful()) {
								showMessage(" The shield Verification Link has been sent to your email !"); } else {
								showMessage ("Verification Link could not be sent !");}
						} });
					//powered by Toxic
					
					fdb.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(data);
					edittextname.setText("");
					edittextphone.setText("");
					linearname.setVisibility(View.GONE);
					linearemail.setVisibility(View.VISIBLE);
					linearphone.setVisibility(View.GONE);
					linearpassword.setVisibility(View.VISIBLE);
					buttonsighnup.setVisibility(View.GONE);
					buttonlogin.setVisibility(View.VISIBLE);
					login.setVisibility(View.VISIBLE);
					sighnup.setVisibility(View.GONE);
					linearloading.setVisibility(View.GONE);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
					linearloading.setVisibility(View.GONE);
				}
			}
		};
		
		_fauth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					linearloading.setVisibility(View.GONE);
					sp.edit().putString("email", edittextemail.getText().toString()).commit();
					sp.edit().putString("password", edittextpassword.getText().toString()).commit();
					SketchwareUtil.showMessage(getApplicationContext(), "login successful");
					i.setClass(getApplicationContext(), HomeActivity.class);
					startActivity(i);
					finish();
				}
				else {
					linearloading.setVisibility(View.GONE);
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
				}
			}
		};
		
		_fauth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				if (_success) {
					linearloading.setVisibility(View.GONE);
					SketchwareUtil.showMessage(getApplicationContext(), "Password reset Link has been sent to your email");
				}
				else {
					linearloading.setVisibility(View.GONE);
					SketchwareUtil.showMessage(getApplicationContext(), "please try after sometimes");
				}
			}
		};
	}
	
	private void initializeLogic() {
		buttonlogin.setVisibility(View.GONE);
		sighnup.setVisibility(View.GONE);
		sendlink.setVisibility(View.GONE);
		linearname.setVisibility(View.GONE);
		linearphone.setVisibility(View.GONE);
		textviewheader.setText("Login");
		buttonsighnup.setVisibility(View.VISIBLE);
		linearemail.setVisibility(View.VISIBLE);
		linearpassword.setVisibility(View.VISIBLE);
		login.setVisibility(View.VISIBLE);
		textviewforgot.setVisibility(View.VISIBLE);
		imageviewhide.setVisibility(View.GONE);
		linearloading.setVisibility(View.GONE);
		linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)10, 0xFFFFB74D, 0xFFFFECB3));
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