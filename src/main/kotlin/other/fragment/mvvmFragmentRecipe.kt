package other.fragment

import com.android.tools.idea.wizard.template.Language
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.common.model.mvvmModel
import other.common.model.mvvmModelJava
import other.common.viewmodel.mvvmViewModelJava
import other.common.viewmodel.mvvmViewModelKt
import other.common.res.layout.mvvmXml
import other.fragment.src.app_package.mvvmFragmentJava
import other.fragment.src.app_package.mvvmFragmentKt

fun RecipeExecutor.mvvmFragmentRecipe(
    moduleData: ModuleTemplateData,
    fragmentClass: String,
    layoutName: String,
    packageName: String,
    language: Language
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = language.extension
//    generateManifest(
//            moduleData = moduleData,
//            activityClass = "${activityClass}Activity",
//            activityTitle = activityClass,
//            packageName = packageName,
//            isLauncher = false,
//            hasNoActionBar = false,
//            generateActivityTitle = true,
//            requireTheme = false,
//            useMaterial2 = false
//    )
//applicationPackage
    if (language == Language.Kotlin) {
        val mvvmFragment =
            mvvmFragmentKt(projectData.applicationPackage, fragmentClass, layoutName, packageName)
        // 保存fragment
        save(mvvmFragment, srcOut.resolve("ui/fragment/${fragmentClass}Fragment.${ktOrJavaExt}"))
        // 保存xml
        save(mvvmXml(packageName, fragmentClass), resOut.resolve("layout/${layoutName}.xml"))
        // 保存viewmodel
        save(
            mvvmViewModelKt(packageName, fragmentClass),
            srcOut.resolve("viewmodel/${fragmentClass}ViewModel.${ktOrJavaExt}")
        )
//     保存repository
//        save(
//            mvvmRepositoryKt(packageName, fragmentClass),
//            srcOut.resolve("repository/${fragmentClass}Repository.${ktOrJavaExt}")
//        )
        //保存Model
        save(
            mvvmModel(packageName, fragmentClass),
            srcOut.resolve("model/${fragmentClass}Model.${ktOrJavaExt}")
        )

    } else if (language == Language.Java) {
        val mvvmFragment =
            mvvmFragmentJava(projectData.applicationPackage, fragmentClass, layoutName, packageName)
        // 保存fragment
        save(mvvmFragment, srcOut.resolve("ui/fragment/${fragmentClass}Fragment.${ktOrJavaExt}"))
        // 保存xml
        save(mvvmXml(packageName, fragmentClass), resOut.resolve("layout/${layoutName}.xml"))
        // 保存viewmodel
        save(
            mvvmViewModelJava(packageName, fragmentClass),
            srcOut.resolve("viewmodel/${fragmentClass}ViewModel.${ktOrJavaExt}")
        )
//     保存repository
//        save(
//            mvvmRepositoryJava(packageName, fragmentClass),
//            srcOut.resolve("repository/${fragmentClass}Repository.${ktOrJavaExt}")
//        )
        //保存Model
        save(
            mvvmModelJava(packageName, fragmentClass),
            srcOut.resolve("model/${fragmentClass}Model.${ktOrJavaExt}")
        )
    }

}