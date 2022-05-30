package other.activity

import com.android.tools.idea.wizard.template.Language
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.common.res.layout.mvvmXml
import other.activity.src.app_package.*
import other.common.model.mvvmModel
import other.common.model.mvvmModelJava
import other.common.saveModel
import other.common.saveViewModel
import other.common.viewmodel.mvvmViewModelJava
import other.common.viewmodel.mvvmViewModelKt

fun RecipeExecutor.mvvmActivityRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    layoutName: String,
    packageName: String,
    language: Language,
    bindingClass: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = language.extension//projectData.language.extension
//    generateManifest(
//        moduleData = moduleData,
//        activityClass = "${activityClass}Activity",
////            activityTitle = activityClass,
//        packageName = "${packageName}.ui",
//        isLauncher = false,
//        hasNoActionBar = false,
//        generateActivityTitle = true,
////            requireTheme = false,
////            useMaterial2 = false
//    )

    val pkAge = projectData.applicationPackage ?: packageName

    if (language == Language.Kotlin) {
        //applicationPackage
        val mvvmActivity =
            mvvmActivityKt(
                pkAge,
                activityClass,
                layoutName,
                packageName,
                bindingClass,
            )
        // 保存Activity
        save(mvvmActivity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
        // 保存xml
        save(mvvmXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
        //合并manifestxml
//        mergeXml(
//            manifestXml(
//                moduleData.projectTemplateData.applicationPackage,
//                packageName,
//                activityClass
//            ), manifestDirOut.resolve("AndroidManifest.xml")
//        )
        // 保存viewmodel
        save(
            mvvmViewModelKt(pkAge, activityClass),
            saveViewModel(
                srcOut,
                pkAge,
                packageName,
                moduleData.srcDir.absolutePath,
                activityClass,
                ktOrJavaExt
            )
        )
        // 保存repository
//        save(
//            mvvmRepositoryKt(packageName, activityClass),
//            srcOut.resolve("repository/${activityClass}Repository.${ktOrJavaExt}")
//        )
        //保存model
        save(
            mvvmModel(pkAge, activityClass),
            saveModel(
                srcOut,
                pkAge,
                packageName,
                moduleData.srcDir.absolutePath,
                activityClass,
                ktOrJavaExt
            )
        )
    } else if (language == Language.Java) {
        //applicationPackage
        val mvvmActivity =
            mvvmActivityJava(
                pkAge,
                activityClass,
                layoutName,
                packageName,
                bindingClass
            )
        // 保存Activity
        save(mvvmActivity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
        // 保存xml
        save(mvvmXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
        //合并manifestxml
//        mergeXml(
//            manifestXml(
//                moduleData.projectTemplateData.applicationPackage,
//                packageName,
//                activityClass
//            ), manifestDirOut.resolve("AndroidManifest.xml")
//        )
        // 保存viewmodel
        save(
            mvvmViewModelJava(pkAge, activityClass),
            saveViewModel(
                srcOut,
                pkAge,
                packageName,
                moduleData.srcDir.absolutePath,
                activityClass,
                ktOrJavaExt
            )
        )
        // 保存repository
//        save(
//            mvvmRepositoryJava(packageName, activityClass),
//            srcOut.resolve("repository/${activityClass}Repository.${ktOrJavaExt}")
//        )
        //保存model
        save(
            mvvmModelJava(pkAge, activityClass),
            saveModel(
                srcOut,
                pkAge,
                packageName,
                moduleData.srcDir.absolutePath,
                activityClass,
                ktOrJavaExt
            )
        )
    }

}
