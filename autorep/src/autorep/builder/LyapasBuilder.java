package autorep.builder;


//import org.antlr.v4.runtime.ANTLRInputStream;
//import org.antlr.v4.runtime.CommonTokenStream;
import java.util.Map;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import autorep.Activator;
import autorep.antlr.lyapasLexer;
import autorep.antlr.lyapasParser;
import autorep.antlr.lyapasParser.FunctionContext;

public class LyapasBuilder extends IncrementalProjectBuilder {

	class LyapasDeltaVisitor implements IResourceDeltaVisitor {
		
		@Override
		public boolean visit(IResourceDelta delta) throws CoreException {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	
	class LyapasResourceVisitor implements IResourceVisitor {
		public boolean visit(IResource resource) {
			checkLyapas(resource);
			
			return true;
		}
	}
	


	public static final String BUILDER_ID = "autorep.LyapasBuilder";

	protected IProject[] build(int kind, Map args, IProgressMonitor monitor)
			throws CoreException {
		ILog log = Activator.getDefault().getLog();
		IStatus status = new Status(IStatus.INFO, Activator.PLUGIN_ID, "BUILD");
		log.log(status);

		fullBuild(monitor);
		
		return null;
	}


	protected void fullBuild(final IProgressMonitor monitor)
			throws CoreException {
		getProject().accept(new LyapasResourceVisitor());
	}

	void checkLyapas(IResource resource){
		
		if (resource instanceof IFile && resource.getName().endsWith(".l")) {
			IFile file = (IFile) resource;
			
			ANTLRInputStream input;
			
			try {
				input = new ANTLRInputStream(file.getContents());
			} catch (Exception e) {
				// FIXME: write handler!!!
				return;
			}
			
			// Настраиваем лексер на этот поток
			lyapasLexer lexer = new lyapasLexer(input);

			// Создаем поток токенов на основе лексера
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			// Создаем парсер
			lyapasParser parser = new lyapasParser(tokens);

			// И запускаем первое правило грамматики!!!
		
			parser.function();
			
			
		}
		
	}

}

