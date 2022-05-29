package other.activity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

val mvvmActivityTemplate
    get() = template {
        //reversion = 1
        name = "MVVM Activity"
        description = "适用于AI-WAYS-MVVM框架的Activity"
        minApi = MIN_API
        //minBuildApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )

        val packageName = defaultPackageNameParameter

        lateinit var layoutName: StringParameter

        val activityClass = stringParameter {
            name = "Activity Name(只输入名字，不要包含Activity)"
            default = "Main"
            help = "只输入名字，不要包含Activity"
            constraints = listOf(Constraint.NONEMPTY)
        }

        layoutName = stringParameter {
            name = "Layout Name"
            default = "activity_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "${activityToLayout(activityClass.value.toLowerCase())}" }
        }



        val language = enumParameter<Language> {
            name = "Source Language"
            help = "请选择语言"
            default = Language.Kotlin
        }

        widgets(
            PackageNameWidget(packageName),
            TextFieldWidget(activityClass),
            TextFieldWidget(layoutName),
            EnumWidget(language)
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            mvvmActivityRecipe(
                data as ModuleTemplateData,
                activityClass.value,
                layoutName.value,
                packageName.value,
                language.value
            )
        }
    }


val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.mycompany.myapp"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }

fun createLayoutName(className: String): String {
    val array = className.toCharArray()
    val string = StringBuilder()
    array.forEach {
        if (it.isUpperCase()) {
            //第一个首字母大写的话 不加下划线
            if (string.isNotEmpty()) {
                string.append("_")
            }
            string.append(it.toLowerCase())
        } else {
            string.append(it)
        }
    }
    return string.toString()
}