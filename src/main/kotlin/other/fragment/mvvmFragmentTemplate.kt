package other.fragment

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

val mvvmFragmentTemplate
    get() = template {
//        revision = 1
        name = "MVVM Fragment"
        description = "适用于AI-WAYS-MVVM框架的Fragment"
        minApi = MIN_API
        minApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        val fragmentClass = stringParameter {
            name = "Fragment Name(只输入名字，不要包含Fragment)"
            default = "Main"
            help = "只输入名字，不要包含Fragment"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val layoutName = stringParameter {
            name = "Layout Name"
            default = "activity_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { fragmentToLayout(fragmentClass.value.toLowerCase()) }
        }

        val language= enumParameter<Language> {
            name = "Source Language"
            help = "请选择语言"
            default = Language.Kotlin
        }

        val packageName = defaultPackageNameParameter

        widgets(
            PackageNameWidget(packageName),
            TextFieldWidget(fragmentClass),
            TextFieldWidget(layoutName),
            EnumWidget(language),
        )
//        thumb { File("logo.png") }

        recipe = { data: TemplateData ->
            mvvmFragmentRecipe(
                data as ModuleTemplateData,
                fragmentClass.value,
                layoutName.value,
                packageName.value,
                language.value,
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

fun createLayoutName(className:String):String{
    val array=className.toCharArray()
    val string= StringBuilder()
    array.forEach {
        if (it.isUpperCase()){
            //第一个首字母大写的话 不加下划线
            if (string.isNotEmpty()){
                string.append("_")
            }
            string.append(it.toLowerCase())
        }else {
            string.append(it)
        }
    }
    return string.toString()
}
