/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.safetycenter.config.cts

import android.content.res.Resources
import android.os.Build.VERSION_CODES.TIRAMISU
import android.safetycenter.config.SafetySource
import android.safetycenter.testing.AnyTester
import android.safetycenter.testing.ParcelableTester
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith

/** CTS tests for [SafetySource]. */
@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = TIRAMISU, codeName = "Tiramisu")
class SafetySourceTest {
    @Test
    fun getType_returnsType() {
        assertThat(DYNAMIC_BAREBONE.type).isEqualTo(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
        assertThat(DYNAMIC_ALL_OPTIONAL.type).isEqualTo(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
        assertThat(DYNAMIC_HIDDEN.type).isEqualTo(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
        assertThat(DYNAMIC_DISABLED.type).isEqualTo(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
        assertThat(STATIC_BAREBONE.type).isEqualTo(SafetySource.SAFETY_SOURCE_TYPE_STATIC)
        assertThat(STATIC_ALL_OPTIONAL.type).isEqualTo(SafetySource.SAFETY_SOURCE_TYPE_STATIC)
        assertThat(ISSUE_ONLY_BAREBONE.type).isEqualTo(SafetySource.SAFETY_SOURCE_TYPE_ISSUE_ONLY)
        assertThat(ISSUE_ONLY_ALL_OPTIONAL.type)
            .isEqualTo(SafetySource.SAFETY_SOURCE_TYPE_ISSUE_ONLY)
    }

    @Test
    fun getId_returnsId() {
        assertThat(DYNAMIC_BAREBONE.id).isEqualTo(DYNAMIC_BAREBONE_ID)
        assertThat(DYNAMIC_ALL_OPTIONAL.id).isEqualTo(DYNAMIC_ALL_OPTIONAL_ID)
        assertThat(DYNAMIC_HIDDEN.id).isEqualTo(DYNAMIC_HIDDEN_ID)
        assertThat(DYNAMIC_DISABLED.id).isEqualTo(DYNAMIC_DISABLED_ID)
        assertThat(STATIC_BAREBONE.id).isEqualTo(STATIC_BAREBONE_ID)
        assertThat(STATIC_ALL_OPTIONAL.id).isEqualTo(STATIC_ALL_OPTIONAL_ID)
        assertThat(ISSUE_ONLY_BAREBONE.id).isEqualTo(ISSUE_ONLY_BAREBONE_ID)
        assertThat(ISSUE_ONLY_ALL_OPTIONAL.id).isEqualTo(ISSUE_ONLY_ALL_OPTIONAL_ID)
    }

    @Test
    fun getPackageName_returnsPackageNameOrThrows() {
        assertThat(DYNAMIC_BAREBONE.packageName).isEqualTo(PACKAGE_NAME)
        assertThat(DYNAMIC_ALL_OPTIONAL.packageName).isEqualTo(PACKAGE_NAME)
        assertThat(DYNAMIC_HIDDEN.packageName).isEqualTo(PACKAGE_NAME)
        assertThat(DYNAMIC_DISABLED.packageName).isEqualTo(PACKAGE_NAME)
        assertThrows(UnsupportedOperationException::class.java) {
            STATIC_BAREBONE.packageName
        }
        assertThrows(UnsupportedOperationException::class.java) {
            STATIC_ALL_OPTIONAL.packageName
        }
        assertThat(ISSUE_ONLY_BAREBONE.packageName).isEqualTo(PACKAGE_NAME)
        assertThat(ISSUE_ONLY_ALL_OPTIONAL.packageName).isEqualTo(PACKAGE_NAME)
    }

    @Test
    fun getTitleResId_returnsTitleResIdOrThrows() {
        assertThat(DYNAMIC_BAREBONE.titleResId).isEqualTo(REFERENCE_RES_ID)
        assertThat(DYNAMIC_ALL_OPTIONAL.titleResId).isEqualTo(REFERENCE_RES_ID)
        assertThat(DYNAMIC_DISABLED.titleResId).isEqualTo(REFERENCE_RES_ID)
        assertThat(DYNAMIC_HIDDEN.titleResId).isEqualTo(Resources.ID_NULL)
        assertThat(STATIC_BAREBONE.titleResId).isEqualTo(REFERENCE_RES_ID)
        assertThat(STATIC_ALL_OPTIONAL.titleResId).isEqualTo(REFERENCE_RES_ID)
        assertThrows(UnsupportedOperationException::class.java) {
            ISSUE_ONLY_BAREBONE.titleResId
        }
        assertThrows(UnsupportedOperationException::class.java) {
            ISSUE_ONLY_ALL_OPTIONAL.titleResId
        }
    }

    @Test
    fun getTitleForWorkResId_returnsTitleForWorkResIdOrThrows() {
        assertThrows(UnsupportedOperationException::class.java) {
            DYNAMIC_BAREBONE.titleForWorkResId
        }
        assertThat(DYNAMIC_ALL_OPTIONAL.titleForWorkResId).isEqualTo(REFERENCE_RES_ID)
        assertThrows(UnsupportedOperationException::class.java) {
            DYNAMIC_DISABLED.titleForWorkResId
        }
        assertThat(DYNAMIC_HIDDEN.titleForWorkResId).isEqualTo(Resources.ID_NULL)
        assertThrows(UnsupportedOperationException::class.java) {
            STATIC_BAREBONE.titleForWorkResId
        }
        assertThat(STATIC_ALL_OPTIONAL.titleForWorkResId).isEqualTo(REFERENCE_RES_ID)
        assertThrows(UnsupportedOperationException::class.java) {
            ISSUE_ONLY_BAREBONE.titleForWorkResId
        }
        assertThrows(UnsupportedOperationException::class.java) {
            ISSUE_ONLY_ALL_OPTIONAL.titleForWorkResId
        }
    }

    @Test
    fun getSummaryResId_returnsSummaryResIdOrThrows() {
        assertThat(DYNAMIC_BAREBONE.summaryResId).isEqualTo(REFERENCE_RES_ID)
        assertThat(DYNAMIC_ALL_OPTIONAL.summaryResId).isEqualTo(REFERENCE_RES_ID)
        assertThat(DYNAMIC_DISABLED.summaryResId).isEqualTo(REFERENCE_RES_ID)
        assertThat(DYNAMIC_HIDDEN.summaryResId).isEqualTo(Resources.ID_NULL)
        assertThat(STATIC_BAREBONE.summaryResId).isEqualTo(REFERENCE_RES_ID)
        assertThat(STATIC_ALL_OPTIONAL.summaryResId).isEqualTo(REFERENCE_RES_ID)
        assertThrows(UnsupportedOperationException::class.java) {
            ISSUE_ONLY_BAREBONE.summaryResId
        }
        assertThrows(UnsupportedOperationException::class.java) {
            ISSUE_ONLY_ALL_OPTIONAL.summaryResId
        }
    }

    @Test
    fun getIntentAction_returnsIntentActionOrThrows() {
        assertThat(DYNAMIC_BAREBONE.intentAction).isEqualTo(INTENT_ACTION)
        assertThat(DYNAMIC_ALL_OPTIONAL.intentAction).isEqualTo(INTENT_ACTION)
        assertThat(DYNAMIC_DISABLED.intentAction).isNull()
        assertThat(DYNAMIC_HIDDEN.intentAction).isNull()
        assertThat(STATIC_BAREBONE.intentAction).isEqualTo(INTENT_ACTION)
        assertThat(STATIC_ALL_OPTIONAL.intentAction).isEqualTo(INTENT_ACTION)
        assertThrows(UnsupportedOperationException::class.java) {
            ISSUE_ONLY_BAREBONE.intentAction
        }
        assertThrows(UnsupportedOperationException::class.java) {
            ISSUE_ONLY_ALL_OPTIONAL.intentAction
        }
    }

    @Test
    fun getProfile_returnsProfile() {
        assertThat(DYNAMIC_BAREBONE.profile).isEqualTo(SafetySource.PROFILE_PRIMARY)
        assertThat(DYNAMIC_ALL_OPTIONAL.profile).isEqualTo(SafetySource.PROFILE_ALL)
        assertThat(DYNAMIC_DISABLED.profile).isEqualTo(SafetySource.PROFILE_PRIMARY)
        assertThat(DYNAMIC_HIDDEN.profile).isEqualTo(SafetySource.PROFILE_ALL)
        assertThat(STATIC_BAREBONE.profile).isEqualTo(SafetySource.PROFILE_PRIMARY)
        assertThat(STATIC_ALL_OPTIONAL.profile).isEqualTo(SafetySource.PROFILE_ALL)
        assertThat(ISSUE_ONLY_BAREBONE.profile).isEqualTo(SafetySource.PROFILE_PRIMARY)
        assertThat(ISSUE_ONLY_ALL_OPTIONAL.profile).isEqualTo(SafetySource.PROFILE_ALL)
    }

    @Test
    fun getInitialDisplayState_returnsInitialDisplayStateOrThrows() {
        assertThat(DYNAMIC_BAREBONE.initialDisplayState)
            .isEqualTo(SafetySource.INITIAL_DISPLAY_STATE_ENABLED)
        assertThat(DYNAMIC_ALL_OPTIONAL.initialDisplayState)
            .isEqualTo(SafetySource.INITIAL_DISPLAY_STATE_DISABLED)
        assertThat(DYNAMIC_DISABLED.initialDisplayState)
            .isEqualTo(SafetySource.INITIAL_DISPLAY_STATE_DISABLED)
        assertThat(DYNAMIC_HIDDEN.initialDisplayState)
            .isEqualTo(SafetySource.INITIAL_DISPLAY_STATE_HIDDEN)
        assertThrows(UnsupportedOperationException::class.java) {
            STATIC_BAREBONE.initialDisplayState
        }
        assertThrows(UnsupportedOperationException::class.java) {
            STATIC_ALL_OPTIONAL.initialDisplayState
        }
        assertThrows(UnsupportedOperationException::class.java) {
            ISSUE_ONLY_BAREBONE.initialDisplayState
        }
        assertThrows(UnsupportedOperationException::class.java) {
            ISSUE_ONLY_ALL_OPTIONAL.initialDisplayState
        }
    }

    @Test
    fun getMaxSeverityLevel_returnsMaxSeverityLevelOrThrows() {
        assertThat(DYNAMIC_BAREBONE.maxSeverityLevel).isEqualTo(Integer.MAX_VALUE)
        assertThat(DYNAMIC_ALL_OPTIONAL.maxSeverityLevel).isEqualTo(MAX_SEVERITY_LEVEL)
        assertThat(DYNAMIC_DISABLED.maxSeverityLevel).isEqualTo(Integer.MAX_VALUE)
        assertThat(DYNAMIC_HIDDEN.maxSeverityLevel).isEqualTo(Integer.MAX_VALUE)
        assertThrows(UnsupportedOperationException::class.java) {
            STATIC_BAREBONE.maxSeverityLevel
        }
        assertThrows(UnsupportedOperationException::class.java) {
            STATIC_ALL_OPTIONAL.maxSeverityLevel
        }
        assertThat(ISSUE_ONLY_BAREBONE.maxSeverityLevel).isEqualTo(Integer.MAX_VALUE)
        assertThat(ISSUE_ONLY_ALL_OPTIONAL.maxSeverityLevel).isEqualTo(MAX_SEVERITY_LEVEL)
    }

    @Test
    fun getSearchTermsResId_returnsSearchTermsResIdOrThrows() {
        assertThat(DYNAMIC_BAREBONE.searchTermsResId).isEqualTo(Resources.ID_NULL)
        assertThat(DYNAMIC_ALL_OPTIONAL.searchTermsResId).isEqualTo(REFERENCE_RES_ID)
        assertThat(DYNAMIC_DISABLED.searchTermsResId).isEqualTo(Resources.ID_NULL)
        assertThat(DYNAMIC_HIDDEN.searchTermsResId).isEqualTo(Resources.ID_NULL)
        assertThat(STATIC_BAREBONE.searchTermsResId).isEqualTo(Resources.ID_NULL)
        assertThat(STATIC_ALL_OPTIONAL.searchTermsResId).isEqualTo(REFERENCE_RES_ID)
        assertThrows(UnsupportedOperationException::class.java) {
            ISSUE_ONLY_BAREBONE.searchTermsResId
        }
        assertThrows(UnsupportedOperationException::class.java) {
            ISSUE_ONLY_ALL_OPTIONAL.searchTermsResId
        }
    }

    @Test
    fun getBroadcastReceiverClassName_returnsBroadcastReceiverClassNameOrThrows() {
        assertThat(DYNAMIC_BAREBONE.broadcastReceiverClassName).isNull()
        assertThat(DYNAMIC_ALL_OPTIONAL.broadcastReceiverClassName)
            .isEqualTo(BROADCAST_RECEIVER_CLASS_NAME)
        assertThat(DYNAMIC_DISABLED.broadcastReceiverClassName).isNull()
        assertThat(DYNAMIC_HIDDEN.broadcastReceiverClassName).isNull()
        assertThrows(UnsupportedOperationException::class.java) {
            STATIC_BAREBONE.broadcastReceiverClassName
        }
        assertThrows(UnsupportedOperationException::class.java) {
            STATIC_ALL_OPTIONAL.broadcastReceiverClassName
        }
        assertThat(ISSUE_ONLY_BAREBONE.broadcastReceiverClassName).isNull()
        assertThat(ISSUE_ONLY_ALL_OPTIONAL.broadcastReceiverClassName)
            .isEqualTo(BROADCAST_RECEIVER_CLASS_NAME)
    }

    @Test
    fun isLoggingAllowed_returnsLoggingAllowedOrThrows() {
        assertThat(DYNAMIC_BAREBONE.isLoggingAllowed).isEqualTo(true)
        assertThat(DYNAMIC_ALL_OPTIONAL.isLoggingAllowed).isEqualTo(false)
        assertThat(DYNAMIC_DISABLED.isLoggingAllowed).isEqualTo(true)
        assertThat(DYNAMIC_HIDDEN.isLoggingAllowed).isEqualTo(true)
        assertThrows(UnsupportedOperationException::class.java) {
            STATIC_BAREBONE.isLoggingAllowed
        }
        assertThrows(UnsupportedOperationException::class.java) {
            STATIC_ALL_OPTIONAL.isLoggingAllowed
        }
        assertThat(ISSUE_ONLY_BAREBONE.isLoggingAllowed).isEqualTo(true)
        assertThat(ISSUE_ONLY_ALL_OPTIONAL.isLoggingAllowed).isEqualTo(false)
    }

    @Test
    fun isRefreshOnPageOpenAllowed_returnsRefreshOnPageOpenAllowedOrThrows() {
        assertThat(DYNAMIC_BAREBONE.isRefreshOnPageOpenAllowed).isEqualTo(false)
        assertThat(DYNAMIC_ALL_OPTIONAL.isRefreshOnPageOpenAllowed).isEqualTo(true)
        assertThat(DYNAMIC_DISABLED.isRefreshOnPageOpenAllowed).isEqualTo(false)
        assertThat(DYNAMIC_HIDDEN.isRefreshOnPageOpenAllowed).isEqualTo(false)
        assertThrows(UnsupportedOperationException::class.java) {
            STATIC_BAREBONE.isRefreshOnPageOpenAllowed
        }
        assertThrows(UnsupportedOperationException::class.java) {
            STATIC_ALL_OPTIONAL.isRefreshOnPageOpenAllowed
        }
        assertThat(ISSUE_ONLY_BAREBONE.isRefreshOnPageOpenAllowed).isEqualTo(false)
        assertThat(ISSUE_ONLY_ALL_OPTIONAL.isRefreshOnPageOpenAllowed).isEqualTo(true)
    }

    @Test
    fun isAutomaticNotificationFromIssueAllowed_returnsAutoNotificationFromIssueAllowedOrThrows() {
        assertThat(DYNAMIC_BAREBONE.isAutomaticNotificationFromIssueAllowed).isEqualTo(false)
        assertThat(DYNAMIC_ALL_OPTIONAL.isAutomaticNotificationFromIssueAllowed).isEqualTo(true)
        assertThat(DYNAMIC_DISABLED.isAutomaticNotificationFromIssueAllowed).isEqualTo(false)
        assertThat(DYNAMIC_HIDDEN.isAutomaticNotificationFromIssueAllowed).isEqualTo(false)
        assertThrows(UnsupportedOperationException::class.java) {
            STATIC_BAREBONE.isAutomaticNotificationFromIssueAllowed
        }
        assertThrows(UnsupportedOperationException::class.java) {
            STATIC_ALL_OPTIONAL.isAutomaticNotificationFromIssueAllowed
        }
        assertThat(ISSUE_ONLY_BAREBONE.isAutomaticNotificationFromIssueAllowed).isEqualTo(false)
        assertThat(ISSUE_ONLY_ALL_OPTIONAL.isAutomaticNotificationFromIssueAllowed).isEqualTo(true)
    }

    @Test
    fun describeContents_returns0() {
        assertThat(DYNAMIC_BAREBONE.describeContents()).isEqualTo(0)
        assertThat(DYNAMIC_ALL_OPTIONAL.describeContents()).isEqualTo(0)
        assertThat(DYNAMIC_HIDDEN.describeContents()).isEqualTo(0)
        assertThat(DYNAMIC_DISABLED.describeContents()).isEqualTo(0)
        assertThat(STATIC_BAREBONE.describeContents()).isEqualTo(0)
        assertThat(STATIC_ALL_OPTIONAL.describeContents()).isEqualTo(0)
        assertThat(ISSUE_ONLY_BAREBONE.describeContents()).isEqualTo(0)
        assertThat(ISSUE_ONLY_ALL_OPTIONAL.describeContents()).isEqualTo(0)
    }

    @Test
    fun createFromParcel_withWriteToParcel_returnsOriginalSafetySource() {
        ParcelableTester.assertThatRoundTripReturnsOriginal(DYNAMIC_BAREBONE, SafetySource.CREATOR)
        ParcelableTester.assertThatRoundTripReturnsOriginal(
            DYNAMIC_ALL_OPTIONAL,
            SafetySource.CREATOR
        )
        ParcelableTester.assertThatRoundTripReturnsOriginal(DYNAMIC_HIDDEN, SafetySource.CREATOR)
        ParcelableTester.assertThatRoundTripReturnsOriginal(DYNAMIC_DISABLED, SafetySource.CREATOR)
        ParcelableTester.assertThatRoundTripReturnsOriginal(STATIC_BAREBONE, SafetySource.CREATOR)
        ParcelableTester.assertThatRoundTripReturnsOriginal(
            STATIC_ALL_OPTIONAL,
            SafetySource.CREATOR
        )
        ParcelableTester.assertThatRoundTripReturnsOriginal(
            ISSUE_ONLY_BAREBONE,
            SafetySource.CREATOR
        )
        ParcelableTester.assertThatRoundTripReturnsOriginal(
            ISSUE_ONLY_ALL_OPTIONAL,
            SafetySource.CREATOR
        )
    }

    // TODO(b/208473675): Use `EqualsTester` for testing `hashcode` and `equals`.
    @Test
    fun hashCode_equals_toString_withEqualByReference_areEqual() {
        AnyTester.assertThatRepresentationsAreEqual(DYNAMIC_BAREBONE, DYNAMIC_BAREBONE)
        AnyTester.assertThatRepresentationsAreEqual(DYNAMIC_ALL_OPTIONAL, DYNAMIC_ALL_OPTIONAL)
        AnyTester.assertThatRepresentationsAreEqual(DYNAMIC_HIDDEN, DYNAMIC_HIDDEN)
        AnyTester.assertThatRepresentationsAreEqual(DYNAMIC_DISABLED, DYNAMIC_DISABLED)
        AnyTester.assertThatRepresentationsAreEqual(STATIC_BAREBONE, STATIC_BAREBONE)
        AnyTester.assertThatRepresentationsAreEqual(STATIC_ALL_OPTIONAL, STATIC_ALL_OPTIONAL)
        AnyTester.assertThatRepresentationsAreEqual(ISSUE_ONLY_BAREBONE, ISSUE_ONLY_BAREBONE)
        AnyTester.assertThatRepresentationsAreEqual(
            ISSUE_ONLY_ALL_OPTIONAL,
            ISSUE_ONLY_ALL_OPTIONAL
        )
    }

    @Test
    fun hashCode_equals_toString_withAllFieldsEqual_areEqual() {
        val dynamicAllOptionalCopy = SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId(DYNAMIC_ALL_OPTIONAL_ID)
            .setPackageName(PACKAGE_NAME)
            .setTitleResId(REFERENCE_RES_ID)
            .setTitleForWorkResId(REFERENCE_RES_ID)
            .setSummaryResId(REFERENCE_RES_ID)
            .setIntentAction(INTENT_ACTION)
            .setProfile(SafetySource.PROFILE_ALL)
            .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_DISABLED)
            .setMaxSeverityLevel(MAX_SEVERITY_LEVEL)
            .setSearchTermsResId(REFERENCE_RES_ID)
            .setBroadcastReceiverClassName(BROADCAST_RECEIVER_CLASS_NAME)
            .setLoggingAllowed(false)
            .setRefreshOnPageOpenAllowed(true)
            .setAutomaticNotificationFromIssueAllowed(true)
            .build()
        AnyTester.assertThatRepresentationsAreEqual(DYNAMIC_ALL_OPTIONAL, dynamicAllOptionalCopy)
    }

    @Test
    fun hashCode_equals_toString_withDifferentTypes_areNotEqual() {
        AnyTester.assertThatRepresentationsAreNotEqual(DYNAMIC_BAREBONE, STATIC_BAREBONE)
        AnyTester.assertThatRepresentationsAreNotEqual(STATIC_BAREBONE, ISSUE_ONLY_BAREBONE)
        AnyTester.assertThatRepresentationsAreNotEqual(ISSUE_ONLY_BAREBONE, DYNAMIC_BAREBONE)
        AnyTester.assertThatRepresentationsAreNotEqual(DYNAMIC_ALL_OPTIONAL, STATIC_ALL_OPTIONAL)
        AnyTester.assertThatRepresentationsAreNotEqual(STATIC_ALL_OPTIONAL, ISSUE_ONLY_ALL_OPTIONAL)
        AnyTester.assertThatRepresentationsAreNotEqual(
            ISSUE_ONLY_ALL_OPTIONAL,
            DYNAMIC_ALL_OPTIONAL
        )
    }

    @Test
    fun hashCode_equals_toString_withDifferentIds_areNotEqual() {
        val dynamicAllOptionalAlt = SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId("other")
            .setPackageName(PACKAGE_NAME)
            .setTitleResId(REFERENCE_RES_ID)
            .setTitleForWorkResId(REFERENCE_RES_ID)
            .setSummaryResId(REFERENCE_RES_ID)
            .setIntentAction(INTENT_ACTION)
            .setProfile(SafetySource.PROFILE_ALL)
            .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_DISABLED)
            .setMaxSeverityLevel(MAX_SEVERITY_LEVEL)
            .setSearchTermsResId(REFERENCE_RES_ID)
            .setBroadcastReceiverClassName(BROADCAST_RECEIVER_CLASS_NAME)
            .setLoggingAllowed(false)
            .setRefreshOnPageOpenAllowed(true)
            .setAutomaticNotificationFromIssueAllowed(true)
            .build()
        AnyTester.assertThatRepresentationsAreNotEqual(DYNAMIC_ALL_OPTIONAL, dynamicAllOptionalAlt)
    }

    @Test
    fun hashCode_equals_toString_withDifferentPackageNames_areNotEqual() {
        val dynamicAllOptionalAlt = SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId(DYNAMIC_ALL_OPTIONAL_ID)
            .setPackageName("other")
            .setTitleResId(REFERENCE_RES_ID)
            .setTitleForWorkResId(REFERENCE_RES_ID)
            .setSummaryResId(REFERENCE_RES_ID)
            .setIntentAction(INTENT_ACTION)
            .setProfile(SafetySource.PROFILE_ALL)
            .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_DISABLED)
            .setMaxSeverityLevel(MAX_SEVERITY_LEVEL)
            .setSearchTermsResId(REFERENCE_RES_ID)
            .setBroadcastReceiverClassName(BROADCAST_RECEIVER_CLASS_NAME)
            .setLoggingAllowed(false)
            .setRefreshOnPageOpenAllowed(true)
            .setAutomaticNotificationFromIssueAllowed(true)
            .build()
        AnyTester.assertThatRepresentationsAreNotEqual(DYNAMIC_ALL_OPTIONAL, dynamicAllOptionalAlt)
    }

    @Test
    fun hashCode_equals_toString_withDifferentTitleResIds_areNotEqual() {
        val dynamicAllOptionalAlt = SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId(DYNAMIC_ALL_OPTIONAL_ID)
            .setPackageName(PACKAGE_NAME)
            .setTitleResId(-1)
            .setTitleForWorkResId(REFERENCE_RES_ID)
            .setSummaryResId(REFERENCE_RES_ID)
            .setIntentAction(INTENT_ACTION)
            .setProfile(SafetySource.PROFILE_ALL)
            .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_DISABLED)
            .setMaxSeverityLevel(MAX_SEVERITY_LEVEL)
            .setSearchTermsResId(REFERENCE_RES_ID)
            .setBroadcastReceiverClassName(BROADCAST_RECEIVER_CLASS_NAME)
            .setLoggingAllowed(false)
            .setRefreshOnPageOpenAllowed(true)
            .setAutomaticNotificationFromIssueAllowed(true)
            .build()
        AnyTester.assertThatRepresentationsAreNotEqual(DYNAMIC_ALL_OPTIONAL, dynamicAllOptionalAlt)
    }

    @Test
    fun hashCode_equals_toString_withDifferentTitleForWorkResIds_areNotEqual() {
        val dynamicAllOptionalAlt = SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId(DYNAMIC_ALL_OPTIONAL_ID)
            .setPackageName(PACKAGE_NAME)
            .setTitleResId(REFERENCE_RES_ID)
            .setTitleForWorkResId(-1)
            .setSummaryResId(REFERENCE_RES_ID)
            .setIntentAction(INTENT_ACTION)
            .setProfile(SafetySource.PROFILE_ALL)
            .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_DISABLED)
            .setMaxSeverityLevel(MAX_SEVERITY_LEVEL)
            .setSearchTermsResId(REFERENCE_RES_ID)
            .setBroadcastReceiverClassName(BROADCAST_RECEIVER_CLASS_NAME)
            .setLoggingAllowed(false)
            .setRefreshOnPageOpenAllowed(true)
            .setAutomaticNotificationFromIssueAllowed(true)
            .build()
        AnyTester.assertThatRepresentationsAreNotEqual(DYNAMIC_ALL_OPTIONAL, dynamicAllOptionalAlt)
    }

    @Test
    fun hashCode_equals_toString_withDifferentSummaryResIds_areNotEqual() {
        val dynamicAllOptionalAlt = SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId(DYNAMIC_ALL_OPTIONAL_ID)
            .setPackageName(PACKAGE_NAME)
            .setTitleResId(REFERENCE_RES_ID)
            .setTitleForWorkResId(REFERENCE_RES_ID)
            .setSummaryResId(-1)
            .setIntentAction(INTENT_ACTION)
            .setProfile(SafetySource.PROFILE_ALL)
            .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_DISABLED)
            .setMaxSeverityLevel(MAX_SEVERITY_LEVEL)
            .setSearchTermsResId(REFERENCE_RES_ID)
            .setBroadcastReceiverClassName(BROADCAST_RECEIVER_CLASS_NAME)
            .setLoggingAllowed(false)
            .setRefreshOnPageOpenAllowed(true)
            .setAutomaticNotificationFromIssueAllowed(true)
            .build()
        AnyTester.assertThatRepresentationsAreNotEqual(DYNAMIC_ALL_OPTIONAL, dynamicAllOptionalAlt)
    }

    @Test
    fun hashCode_equals_toString_withDifferentIntentActions_areNotEqual() {
        val dynamicAllOptionalAlt = SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId(DYNAMIC_ALL_OPTIONAL_ID)
            .setPackageName(PACKAGE_NAME)
            .setTitleResId(REFERENCE_RES_ID)
            .setTitleForWorkResId(REFERENCE_RES_ID)
            .setSummaryResId(REFERENCE_RES_ID)
            .setIntentAction("other")
            .setProfile(SafetySource.PROFILE_ALL)
            .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_DISABLED)
            .setMaxSeverityLevel(MAX_SEVERITY_LEVEL)
            .setSearchTermsResId(REFERENCE_RES_ID)
            .setBroadcastReceiverClassName(BROADCAST_RECEIVER_CLASS_NAME)
            .setLoggingAllowed(false)
            .setRefreshOnPageOpenAllowed(true)
            .setAutomaticNotificationFromIssueAllowed(true)
            .build()
        AnyTester.assertThatRepresentationsAreNotEqual(DYNAMIC_ALL_OPTIONAL, dynamicAllOptionalAlt)
    }

    @Test
    fun hashCode_equals_toString_withDifferentProfiles_areNotEqual() {
        val dynamicHiddenAlt = SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId(DYNAMIC_HIDDEN_ID)
            .setPackageName(PACKAGE_NAME)
            .setProfile(SafetySource.PROFILE_PRIMARY)
            .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_HIDDEN)
            .build()
        AnyTester.assertThatRepresentationsAreNotEqual(DYNAMIC_HIDDEN, dynamicHiddenAlt)
    }

    @Test
    fun hashCode_equals_toString_withDifferentInitialDisplayStates_areNotEqual() {
        val dynamicAllOptionalAlt = SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId(DYNAMIC_ALL_OPTIONAL_ID)
            .setPackageName(PACKAGE_NAME)
            .setTitleResId(REFERENCE_RES_ID)
            .setTitleForWorkResId(REFERENCE_RES_ID)
            .setSummaryResId(REFERENCE_RES_ID)
            .setIntentAction(INTENT_ACTION)
            .setProfile(SafetySource.PROFILE_ALL)
            .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_ENABLED)
            .setMaxSeverityLevel(MAX_SEVERITY_LEVEL)
            .setSearchTermsResId(REFERENCE_RES_ID)
            .setBroadcastReceiverClassName(BROADCAST_RECEIVER_CLASS_NAME)
            .setLoggingAllowed(false)
            .setRefreshOnPageOpenAllowed(true)
            .setAutomaticNotificationFromIssueAllowed(true)
            .build()
        AnyTester.assertThatRepresentationsAreNotEqual(DYNAMIC_ALL_OPTIONAL, dynamicAllOptionalAlt)
    }

    @Test
    fun hashCode_equals_toString_withDifferentMaxSeverityLevel_areNotEqual() {
        val dynamicAllOptionalAlt = SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId(DYNAMIC_ALL_OPTIONAL_ID)
            .setPackageName(PACKAGE_NAME)
            .setTitleResId(REFERENCE_RES_ID)
            .setTitleForWorkResId(REFERENCE_RES_ID)
            .setSummaryResId(REFERENCE_RES_ID)
            .setIntentAction(INTENT_ACTION)
            .setProfile(SafetySource.PROFILE_ALL)
            .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_DISABLED)
            .setMaxSeverityLevel(-1)
            .setSearchTermsResId(REFERENCE_RES_ID)
            .setBroadcastReceiverClassName(BROADCAST_RECEIVER_CLASS_NAME)
            .setLoggingAllowed(false)
            .setRefreshOnPageOpenAllowed(true)
            .setAutomaticNotificationFromIssueAllowed(true)
            .build()
        AnyTester.assertThatRepresentationsAreNotEqual(DYNAMIC_ALL_OPTIONAL, dynamicAllOptionalAlt)
    }

    @Test
    fun hashCode_equals_toString_withDifferentSearchTermsResIds_areNotEqual() {
        val dynamicAllOptionalAlt = SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId(DYNAMIC_ALL_OPTIONAL_ID)
            .setPackageName(PACKAGE_NAME)
            .setTitleResId(REFERENCE_RES_ID)
            .setTitleForWorkResId(REFERENCE_RES_ID)
            .setSummaryResId(REFERENCE_RES_ID)
            .setIntentAction(INTENT_ACTION)
            .setProfile(SafetySource.PROFILE_ALL)
            .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_DISABLED)
            .setMaxSeverityLevel(MAX_SEVERITY_LEVEL)
            .setSearchTermsResId(-1)
            .setBroadcastReceiverClassName(BROADCAST_RECEIVER_CLASS_NAME)
            .setLoggingAllowed(false)
            .setRefreshOnPageOpenAllowed(true)
            .setAutomaticNotificationFromIssueAllowed(true)
            .build()
        AnyTester.assertThatRepresentationsAreNotEqual(DYNAMIC_ALL_OPTIONAL, dynamicAllOptionalAlt)
    }

    @Test
    fun hashCode_equals_toString_withDifferentBroadcastReceiverClassNames_areNotEqual() {
        val dynamicAllOptionalAlt = SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId(DYNAMIC_ALL_OPTIONAL_ID)
            .setPackageName(PACKAGE_NAME)
            .setTitleResId(REFERENCE_RES_ID)
            .setTitleForWorkResId(REFERENCE_RES_ID)
            .setSummaryResId(REFERENCE_RES_ID)
            .setIntentAction(INTENT_ACTION)
            .setProfile(SafetySource.PROFILE_ALL)
            .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_DISABLED)
            .setMaxSeverityLevel(MAX_SEVERITY_LEVEL)
            .setSearchTermsResId(REFERENCE_RES_ID)
            .setBroadcastReceiverClassName("other")
            .setLoggingAllowed(false)
            .setRefreshOnPageOpenAllowed(true)
            .setAutomaticNotificationFromIssueAllowed(true)
            .build()
        AnyTester.assertThatRepresentationsAreNotEqual(DYNAMIC_ALL_OPTIONAL, dynamicAllOptionalAlt)
    }

    @Test
    fun hashCode_equals_toString_withDifferentLoggingAllowed_areNotEqual() {
        val dynamicAllOptionalAlt = SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId(DYNAMIC_ALL_OPTIONAL_ID)
            .setPackageName(PACKAGE_NAME)
            .setTitleResId(REFERENCE_RES_ID)
            .setTitleForWorkResId(REFERENCE_RES_ID)
            .setSummaryResId(REFERENCE_RES_ID)
            .setIntentAction(INTENT_ACTION)
            .setProfile(SafetySource.PROFILE_ALL)
            .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_DISABLED)
            .setMaxSeverityLevel(MAX_SEVERITY_LEVEL)
            .setSearchTermsResId(REFERENCE_RES_ID)
            .setBroadcastReceiverClassName(BROADCAST_RECEIVER_CLASS_NAME)
            .setLoggingAllowed(true)
            .setRefreshOnPageOpenAllowed(true)
            .setAutomaticNotificationFromIssueAllowed(true)
            .build()
        AnyTester.assertThatRepresentationsAreNotEqual(DYNAMIC_ALL_OPTIONAL, dynamicAllOptionalAlt)
    }

    @Test
    fun hashCode_equals_toString_withDifferentRefreshOnPageOpenAllowed_areNotEqual() {
        val dynamicAllOptionalAlt = SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId(DYNAMIC_ALL_OPTIONAL_ID)
            .setPackageName(PACKAGE_NAME)
            .setTitleResId(REFERENCE_RES_ID)
            .setTitleForWorkResId(REFERENCE_RES_ID)
            .setSummaryResId(REFERENCE_RES_ID)
            .setIntentAction(INTENT_ACTION)
            .setProfile(SafetySource.PROFILE_ALL)
            .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_DISABLED)
            .setMaxSeverityLevel(MAX_SEVERITY_LEVEL)
            .setSearchTermsResId(REFERENCE_RES_ID)
            .setBroadcastReceiverClassName(BROADCAST_RECEIVER_CLASS_NAME)
            .setLoggingAllowed(false)
            .setRefreshOnPageOpenAllowed(false)
            .setAutomaticNotificationFromIssueAllowed(true)
            .build()
        AnyTester.assertThatRepresentationsAreNotEqual(DYNAMIC_ALL_OPTIONAL, dynamicAllOptionalAlt)
    }

    @Test
    fun hashCode_equals_toString_withDifferentAutomaticNotificationFromIssueAllowed_areNotEqual() {
        val dynamicAllOptionalAlt = SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
            .setId(DYNAMIC_ALL_OPTIONAL_ID)
            .setPackageName(PACKAGE_NAME)
            .setTitleResId(REFERENCE_RES_ID)
            .setTitleForWorkResId(REFERENCE_RES_ID)
            .setSummaryResId(REFERENCE_RES_ID)
            .setIntentAction(INTENT_ACTION)
            .setProfile(SafetySource.PROFILE_ALL)
            .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_DISABLED)
            .setMaxSeverityLevel(MAX_SEVERITY_LEVEL)
            .setSearchTermsResId(REFERENCE_RES_ID)
            .setBroadcastReceiverClassName(BROADCAST_RECEIVER_CLASS_NAME)
            .setLoggingAllowed(false)
            .setRefreshOnPageOpenAllowed(true)
            .setAutomaticNotificationFromIssueAllowed(false)
            .build()
        AnyTester.assertThatRepresentationsAreNotEqual(DYNAMIC_ALL_OPTIONAL, dynamicAllOptionalAlt)
    }

    companion object {
        private const val PACKAGE_NAME = "package"
        private const val REFERENCE_RES_ID = 9999
        private const val INTENT_ACTION = "intent"
        private const val BROADCAST_RECEIVER_CLASS_NAME = "broadcast"
        private const val MAX_SEVERITY_LEVEL = 300

        private const val DYNAMIC_BAREBONE_ID = "dynamic_barebone"
        private const val DYNAMIC_ALL_OPTIONAL_ID = "dynamic_all_optional"
        private const val DYNAMIC_DISABLED_ID = "dynamic_disabled"
        private const val DYNAMIC_HIDDEN_ID = "dynamic_hidden"
        private const val STATIC_BAREBONE_ID = "static_barebone"
        private const val STATIC_ALL_OPTIONAL_ID = "static_all_optional"
        private const val ISSUE_ONLY_BAREBONE_ID = "issue_only_barebone"
        private const val ISSUE_ONLY_ALL_OPTIONAL_ID = "issue_only_all_optional"

        internal val DYNAMIC_BAREBONE =
            SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
                .setId(DYNAMIC_BAREBONE_ID)
                .setPackageName(PACKAGE_NAME)
                .setTitleResId(REFERENCE_RES_ID)
                .setSummaryResId(REFERENCE_RES_ID)
                .setIntentAction(INTENT_ACTION)
                .setProfile(SafetySource.PROFILE_PRIMARY)
                .build()

        private val DYNAMIC_ALL_OPTIONAL =
            SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
                .setId(DYNAMIC_ALL_OPTIONAL_ID)
                .setPackageName(PACKAGE_NAME)
                .setTitleResId(REFERENCE_RES_ID)
                .setTitleForWorkResId(REFERENCE_RES_ID)
                .setSummaryResId(REFERENCE_RES_ID)
                .setIntentAction(INTENT_ACTION)
                .setProfile(SafetySource.PROFILE_ALL)
                .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_DISABLED)
                .setMaxSeverityLevel(MAX_SEVERITY_LEVEL)
                .setSearchTermsResId(REFERENCE_RES_ID)
                .setBroadcastReceiverClassName(BROADCAST_RECEIVER_CLASS_NAME)
                .setLoggingAllowed(false)
                .setRefreshOnPageOpenAllowed(true)
                .setAutomaticNotificationFromIssueAllowed(true)
                .build()

        private val DYNAMIC_DISABLED =
            SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
                .setId(DYNAMIC_DISABLED_ID)
                .setPackageName(PACKAGE_NAME)
                .setTitleResId(REFERENCE_RES_ID)
                .setSummaryResId(REFERENCE_RES_ID)
                .setProfile(SafetySource.PROFILE_PRIMARY)
                .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_DISABLED)
                .build()

        private val DYNAMIC_HIDDEN =
            SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_DYNAMIC)
                .setId(DYNAMIC_HIDDEN_ID)
                .setPackageName(PACKAGE_NAME)
                .setProfile(SafetySource.PROFILE_ALL)
                .setInitialDisplayState(SafetySource.INITIAL_DISPLAY_STATE_HIDDEN)
                .build()

        internal val STATIC_BAREBONE =
            SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_STATIC)
                .setId(STATIC_BAREBONE_ID)
                .setTitleResId(REFERENCE_RES_ID)
                .setSummaryResId(REFERENCE_RES_ID)
                .setIntentAction(INTENT_ACTION)
                .setProfile(SafetySource.PROFILE_PRIMARY)
                .build()

        private val STATIC_ALL_OPTIONAL =
            SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_STATIC)
                .setId(STATIC_ALL_OPTIONAL_ID)
                .setTitleResId(REFERENCE_RES_ID)
                .setTitleForWorkResId(REFERENCE_RES_ID)
                .setSummaryResId(REFERENCE_RES_ID)
                .setIntentAction(INTENT_ACTION)
                .setProfile(SafetySource.PROFILE_ALL)
                .setSearchTermsResId(REFERENCE_RES_ID)
                .build()

        internal val ISSUE_ONLY_BAREBONE =
            SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_ISSUE_ONLY)
                .setId(ISSUE_ONLY_BAREBONE_ID)
                .setPackageName(PACKAGE_NAME)
                .setProfile(SafetySource.PROFILE_PRIMARY)
                .build()

        private val ISSUE_ONLY_ALL_OPTIONAL =
            SafetySource.Builder(SafetySource.SAFETY_SOURCE_TYPE_ISSUE_ONLY)
                .setId(ISSUE_ONLY_ALL_OPTIONAL_ID)
                .setPackageName(PACKAGE_NAME)
                .setProfile(SafetySource.PROFILE_ALL)
                .setMaxSeverityLevel(MAX_SEVERITY_LEVEL)
                .setBroadcastReceiverClassName(BROADCAST_RECEIVER_CLASS_NAME)
                .setLoggingAllowed(false)
                .setRefreshOnPageOpenAllowed(true)
                .setAutomaticNotificationFromIssueAllowed(true)
                .build()
    }
}
