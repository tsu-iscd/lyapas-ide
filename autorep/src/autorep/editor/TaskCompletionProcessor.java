package autorep.editor;

import java.util.ArrayList;
import org.eclipse.jface.text.*;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class TaskCompletionProcessor implements IContentAssistProcessor {

	@Override
    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {

            
            IDocument doc = viewer.getDocument();          

            List<ICompletionProposal> completionProposals = new ArrayList<ICompletionProposal>();

    			char s = ' ';
    			String c;;

    				try {
						s = doc.getChar(offset-1);
					} catch (BadLocationException e) {
						
					}
 
    				if(s == '='){
    					 c = "⇒";
    					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
    					 
    				}
    				
    				if(s == '<'){
   					 c = "⇔";
   					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
   					 c = "≪";
  					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
  					 c = "≤ ";
 					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
  				   
   				   }
    				if(s == '-'){
   					c = "¬";
   					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
   					c = "⇻ ";
  					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
  					c = "→ ";
  					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
   				}
    				
    				if(s == 'V'){
      					 c = "∨ ";
      					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
      				}
    				
    				if(s == '+'){
      					 c = "⊕ ";
      					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
      				}
    				
    				if(s == '>'){
      					 c = "≫ ";
      					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
      					c = "≥ ";
     					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
      				}
    				
    				if(s == '\\'){
      					 c = "∇ ";
      					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
      				}
    				
    				if(s == '/'){
      					 c = "∆ ";
      					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
      				}
    				
    				if(s == '$'){
      					 c = "§ ";
      					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
      				}
    				
    				if(s == '|'){
      					 c = "↑ ";
      					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
      					c = "⇑ ";
     					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
     					c = "⇓ ";
     					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
     					c = "⇞ ";
    					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
      				}
    				
    				if(s == '0'){
      					 c = "↪ ";
      					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
      					}
    				
    				if(s == '1'){
      					 c = "↦ ";
      					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
      				}
    				
    				if(s == '!'){
     					 c = "≠ ";
     					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
     				}
    				
    				if(s == '~'){
     					 c = "⁻ ";
     					 completionProposals.add(new CompletionProposal(c, offset-1, 1, c.length()));
     				}
    				   
    			
            return completionProposals.toArray(new ICompletionProposal[completionProposals.size()]);
    }

    @Override
    public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
            return null;
    }

    @Override
    public char[] getCompletionProposalAutoActivationCharacters() {
            return null;
    }

    @Override
    public char[] getContextInformationAutoActivationCharacters() {
            return null;
    }

    @Override
    public String getErrorMessage() {
            return null;
    }

    @Override
    public IContextInformationValidator getContextInformationValidator() {
            return null;
    }


}