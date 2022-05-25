# git指令

- cherry-pick 提交的版本 ：将后面的版本添加到当前位置之后，将提交树上任意部分的提交部分追加到HEAD之后
- git branch -f + 分支名 + (提交的版本/HEAD指针指向的位置) ：将分支指向某个提交版本
- git rebase 分支名 ：将当前分支位置之后的提交直接复制到指明的分支之后
  - git rebase 分支名1 分支名2 : 将分支名2rebase到分支名1
- 交互式rebase : git rebase -i +HEAD指针  将HEAD指针遍历过位置的提交重新排序(也可以删除)并将结果复制一份作为新的提交
- 修改commit信息：git commit --amend
- git tag 标签名 提交: 永远指向某个提交的标识 ,不会随着提交而移动(分支会) 
- git describe : 距离当前位置最近的tag 
- 如果一个提交有两个父提交 使用 ^+数字 指向不同的父提交

使用git clone后本地多了一个远程分支 （ 远程仓库名 / 分支名  o/main） 。远程分支反映了上一次通信时远程仓库的状态

修改远程分支会造成分离式HEAD(只有远程仓库更新，远程分支才会更新)

- git fetch : 从远程仓库获取数据 ，实现的功能：将本地仓库中的远程分支更新成了远程仓库相应分支最新的状态。

  - 从远程下载本地仓库缺失的提交版本
  - 更新远程分支指针(如o/main)

  git fetch不会修改本地分支

- git pull : 先抓取更新再合并到本地分支 = git fetch + git merge

- git push：将**你的**变更上传到指定的远程仓库，并在远程仓库上合并你的新提交记录

  - git push + 仓库名+分支名   git push 则采用配置中的设定

## 偏离的提交记录：

远程的最新提交与当前提交的父提交不相同，git push会失效

解决方法：使用rebase (先fetch最新的提交，再rebase最后push到远程仓库) 或者使用merge(先fetch 后merge)

或者 git pull --rebase(与使用rebase流程相同，更加简短)

## 锁定的main(远程仓库)：

远程服务器拒绝直接推送(push)提交到main, 因为策略配置要求 pull requests 来提交更新.

你应该按照流程,新建一个分支, 推送(push)这个分支并申请pull request

解决方法：新建一个分支feature, 推送到远程服务器. 然后reset你的main分支和远程服务器保持一致, 否则下次你pull并且他人的提交和你冲突的时候就会有问题.(让本地main与远程的main指向同一个提交)

## 让自定义的分支追踪远程分支(默认是main分支)

git checkout -b totallyNotMain o/main ： 就可以创建一个名为 `totallyNotMain` 的分支，它跟踪远程分支 `o/main`。

相同的 git branch -u o/main foo 也有类似作用



## git push 的参数：

git push <remote> <place>

git push origin main  ：切到本地仓库中的“main”分支，获取所有的提交，再到远程仓库“origin”中找到“main”分支，将远程仓库中没有的提交记录都添加上去，搞定之后告诉我。

通过“place”参数来告诉 Git 提交记录来自于 main, 要推送到远程仓库中的 main。它实际就是要同步的两个仓库的位置。

如果来源和去向分支的名称不同呢？比如你想把本地的 `foo` 分支推送到远程仓库中的 `bar` 分支。

要同时为源和目的地指定 `<place>` 的话，只需要用冒号 `:` 将二者连起来就可以了：

```
git push origin <source>:<destination>
<source>:<destination> 可以使用分支名(表示当前最新分支)或分支名^表示当前分支之前的提交
```

如果要推送的目标分支不存在，Git 会在远程仓库中根据你提供的名称帮你创建这个分支

## git fetch参数

```
git fetch origin foo
```

Git 会到远程仓库的 `foo` 分支上，然后获取所有本地不存在的提交，放到本地的 `o/foo` 上。

(只更新o/foo的位置 foo位置不变)

**不会更新你的本地的非远程分支, 只是下载提交记录**（这样, 你就可以对远程分支进行检查或者合并了）。

如果 `git fetch` 没有参数，它会下载所有的提交记录到各个远程分支……

留空source，比如：

- `git push origin :side` 会删除远程仓库的side分支
- `git fetch origin :bugFix` 在本地新建一个bugFix分支

## git pull:

`git pull origin foo` 相当于：

```
git fetch origin foo; git merge o/foo
```

还有...

`git pull origin bar~1:bugFix` 相当于：

```
git fetch origin bar~1:bugFix; git merge bugFix
```

看到了? git pull 实际上就是 fetch + merge 的缩写, git pull 唯一关注的是提交最终合并到哪里（也就是为 git fetch 所提供的 destination 参数）





