import net.mamoe.kjbb.compiler.extensions.JvmBlockingBridgeCallResolutionInterceptorExtension
import net.mamoe.kjbb.compiler.extensions.JvmBlockingBridgeCodegenJvmExtension
import net.mamoe.kjbb.compiler.extensions.JvmBlockingBridgeIrGenerationExtension
import net.mamoe.kjbb.compiler.extensions.JvmBlockingBridgeResolveExtension
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.internal.CandidateInterceptor
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension

@Suppress("unused")
open class TestComponentRegistrar : ComponentRegistrar {

    override fun registerProjectComponents(
        project: MockProject,
        configuration: CompilerConfiguration
    ) {
        SyntheticResolveExtension.registerExtension(project, JvmBlockingBridgeResolveExtension())
        CandidateInterceptor.registerExtension(project, JvmBlockingBridgeCallResolutionInterceptorExtension())

        IrGenerationExtension.registerExtension(project, JvmBlockingBridgeIrGenerationExtension())
        ExpressionCodegenExtension.registerExtension(project, JvmBlockingBridgeCodegenJvmExtension())
    }
}


