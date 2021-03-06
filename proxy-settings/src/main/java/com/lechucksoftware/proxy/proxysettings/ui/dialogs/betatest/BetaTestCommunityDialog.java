package com.lechucksoftware.proxy.proxysettings.ui.dialogs.betatest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.lechucksoftware.proxy.proxysettings.App;
import com.lechucksoftware.proxy.proxysettings.R;
import com.lechucksoftware.proxy.proxysettings.ui.base.BaseDialogFragment;
import com.lechucksoftware.proxy.proxysettings.utils.EventsReporter;
import com.lechucksoftware.proxy.proxysettings.utils.UIUtils;

public class BetaTestCommunityDialog extends BaseDialogFragment
{
	public static String TAG = BetaTestCommunityDialog.class.getSimpleName();

    @Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), getTheme());

        builder.setTitle(R.string.welcome_aboard);
		builder.setMessage(R.string.beta_testing_instructions);
		builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface paramDialogInterface, int paramInt)
			{
                App.getEventsReporter().sendEvent(R.string.analytics_cat_user_action,
                        R.string.analytics_act_dialog_button_click,
                        R.string.analytics_lab_beta_test_community_dialog, 1L);

                UIUtils.openBetaTestProject(getActivity());
			}
		});

		AlertDialog alert = builder.create();
		return alert;
	}

    @Override
    public void onCancel(DialogInterface dialog)
    {
        super.onCancel(dialog);

        App.getEventsReporter().sendEvent(R.string.analytics_cat_user_action,
                R.string.analytics_act_dialog_button_click,
                R.string.analytics_lab_beta_test_community_dialog, 2L);
    }

    public static BetaTestCommunityDialog newInstance()
	{
		BetaTestCommunityDialog frag = new BetaTestCommunityDialog();
		return frag;
	}
}
