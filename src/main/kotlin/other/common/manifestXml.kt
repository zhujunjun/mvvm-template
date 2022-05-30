package other.common

fun manifestXml(applicationPackageName: String?, packageName: String, activityClass: String) = """
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="$applicationPackageName">

        <application>
            <activity
                android:name="${packageName}.${activityClass}"
                android:screenOrientation="portrait"
                android:theme="@style/AppTheme.Default"
                />
        </application>

    </manifest>
""".trimIndent()