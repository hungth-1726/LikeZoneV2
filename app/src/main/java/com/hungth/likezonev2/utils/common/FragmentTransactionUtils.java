package com.hungth.likezonev2.utils.common;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static androidx.core.util.Preconditions.checkNotNull;

public class FragmentTransactionUtils {

    public static void addFragment(FragmentManager fragmentManager, Fragment fragment, int res,
                                   String tag, boolean isAddToBackStack) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        Fragment currentFragment = fragmentManager.findFragmentByTag(tag);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (currentFragment != null) {
            showFragment(fragmentManager, transaction, fragment);
            return;
        }
        transaction.add(res, fragment, tag);
        if (isAddToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    private static void showFragment(FragmentManager fragmentManager,
            FragmentTransaction transaction, Fragment fragment) {
        for (int i = 0; i < fragmentManager.getFragments().size(); i++) {
            transaction.hide(fragmentManager.getFragments().get(i));
        }
        transaction.show(fragment).commit();
    }
}